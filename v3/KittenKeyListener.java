import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KittenKeyListener implements KeyListener {
    Notebook nb;
<<<<<<< HEAD
    String contents = "";
    ArrayList<Line> notebook;
=======
>>>>>>> 8e44a73115dae788b2bcbe2fd35136557737d422
    
    public KittenKeyListener(Notebook n) {
        nb = n;
        notebook = nb.getNotebook();
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            nb.writeLine("");
<<<<<<< HEAD
            //refreshContents();
=======
>>>>>>> 8e44a73115dae788b2bcbe2fd35136557737d422
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
<<<<<<< HEAD
        Line current = notebook.get(nb.getCursorPos()-1);
        current.editText(e.getKeyChar());
        notebook.set(nb.getCursorPos(), current);
=======
        return;
>>>>>>> 8e44a73115dae788b2bcbe2fd35136557737d422
    }

    public Notebook returnNotebook() {
        return nb;
    }

<<<<<<< HEAD
    public void refreshContents() {
        contents = "";
    }

    
=======
>>>>>>> 8e44a73115dae788b2bcbe2fd35136557737d422
}