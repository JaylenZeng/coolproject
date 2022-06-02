import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Frame;

public class TestKeyListener implements KeyListener {
    Frame f;
    int ctr;
    public TestKeyListener(Frame f) {
        this.f=f;

    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (ctr < 4) {
            System.out.println("ur good fam");
            ctr++;
            return;
        }
        System.out.println("uh oh closing");
        f.removeKeyListener(this);
        f.addKeyListener(new KittenKeyListener(new Notebook()));
        


        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}