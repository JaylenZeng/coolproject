import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CmdKeyListener implements KeyListener {
    Notebook nb1, nb2;
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
        System.out.print(String.format("\u001B[%d;%dH", nb1.radius+4,0));
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
            cmd=nb2.nbAL.get(0).toString();
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
        int[] special = new int[]{37,38,39,40,8};
        for (int c : special) {
            if (c==e.getKeyCode()){
                Action.process(c,nb2);
                isUnicode = false;
            }
        }
        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && isUnicode) {
            Action.type(e.getKeyChar(),nb2, 80);
        }
        
        refresh();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}