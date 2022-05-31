import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KittenKeyListener implements KeyListener {
    Notebook nb;
    String contents = "";
    ArrayList<Line> notebook;
    
    public KittenKeyListener(Notebook n) {
        nb = n;
        notebook = nb.getNotebook();
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            nb.writeLine("");
            //refreshContents();
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
        Line current = notebook.get(nb.getCursorPos()-1);
        current.editText(e.getKeyChar());
        notebook.set(nb.getCursorPos(), current);
    }

    public Notebook returnNotebook() {
        return nb;
    }

    public void refreshContents() {
        contents = "";
    }

    
}