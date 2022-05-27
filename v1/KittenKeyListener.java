import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class KittenKeyListener {
    Notebook nb;
    
    public KittenKeyListener(Notebook n) {
        nb = n;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nb.setCursorPos(nb.getCursorPos()+1);
        }
    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
}