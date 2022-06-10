import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CmdKeyListener implements KeyListener
{
    Notebook nb1;
    Notebook nb2;
    boolean closed;
    String cmd;
    
    public CmdKeyListener(Notebook nb1, Notebook nb2) {
        this.nb1 = nb1;
        this.nb2 = nb2;
        cmd = "close";
    }
    
    public boolean isOpen() {
        return !closed;
    }
    
    public void refresh() {
        Action.clearScreen();
        System.out.println(nb1);
        System.out.print(String.format("\u001b[%d;%dH", Params.radius * 2 + 4, 0));
        System.out.print("?");
        System.out.println(nb2);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 17) {
            closed = true;
        }
        if (e.getKeyCode() == 10) {
            cmd = nb2.nbAL.get(0).toString();
            closed = true;
        }
        if (closed) {
            Woo.f.removeKeyListener(this);
            Woo.f.addKeyListener(Woo.listener);
            Woo.listener.refresh();
            Action.invokeCommand(cmd, nb1);
            return;
        }
        boolean isUnicode = true;
        for (int special : new int[] { 37, 39, 8 }) {
            if (special == e.getKeyCode()) {
                Action.process(special, nb2);
                isUnicode = false;
            }
        }
        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && isUnicode) {
            Action.type(e.getKeyChar(), nb2);
        }
        refresh();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
}

