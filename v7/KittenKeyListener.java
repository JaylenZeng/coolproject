import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KittenKeyListener implements KeyListener {
    Notebook nb;

    public KittenKeyListener(Notebook nb) {
        this.nb = nb;
        refresh();
    }

    public void refresh() {
        Action.clearScreen();
        System.out.println(nb);
        System.out.println(nb.cursorPos[0]+", "+nb.cursorPos[1]);
        System.out.println(nb.currentWidth());
        System.out.println(nb.cursorPos[1] == nb.currentWidth());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean isUnicode = true;
        int[] special = new int[]{17,37,38,39,40,10,8};
        for (int c : special) {
            if (c==e.getKeyCode()){
                Action.process(c,nb);
                isUnicode = false;
            }
        }
        if (!Woo.f.getKeyListeners()[0].equals(this)) return;
        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && isUnicode) {
            Action.type(e.getKeyChar(),nb,80);
        }
        refresh(); 
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}