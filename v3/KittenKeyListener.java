import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KittenKeyListener implements KeyListener {
    Notebook nb;
    
    public KittenKeyListener(Notebook n) {
        nb = n;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            nb.writeLine("");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nb.moveCursor(-1,0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            nb.moveCursor(1,0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            nb.moveCursor(0,-1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            nb.moveCursor(0,1);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            return;
        }
        
        //(IMPLEMENTING LATER)
        // if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        
        // }
        // if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        
        // }
        // if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

        // }
        // if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

        // }
        
        
    }
    public void keyReleased(KeyEvent e) {
        return;
    }
    public void keyTyped(KeyEvent e) {
        return;
    }

    public Notebook returnNotebook() {
        return nb;
    }

}