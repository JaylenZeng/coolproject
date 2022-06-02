import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KittenKeyListener implements KeyListener {
    Notebook nb;

    public KittenKeyListener(Notebook nb) {
        this.nb = nb;
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
        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && isUnicode) {
            Action.type(e.getKeyChar(),nb);
        }
        Action.clearScreen();
        System.out.println(nb);
        


        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}