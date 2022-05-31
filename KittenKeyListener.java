import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KittenKeyListener implements KeyListener {
    Notebook nb;
    String contents = "";
    
    public KittenKeyListener(Notebook n) {
        nb = n;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            nb.writeLine(contents);
            refreshContents();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            nb.setCursorPos(nb.getCursorPos() + 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            nb.setCursorPos(nb.getCursorPos() - 1);
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

    }
    public void keyTyped(KeyEvent e) {
        contents += e.getKeyChar();
    }

    public Notebook returnNotebook() {
        return nb;
    }

    public void refreshContents() {
        contents = "";
    }
}