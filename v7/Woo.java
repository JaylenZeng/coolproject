import java.awt.Frame;


public class Woo {
    public static Frame f;
    static Notebook nb;
    public static KittenKeyListener listener;

    public static void main(String[] args) {
        nb = new Notebook("kit1"+"\n");
        listener = new KittenKeyListener(nb);

        f = new Frame("KTNBK");
        f.setSize(200,50);
        f.setVisible(true);
        
        f.addKeyListener(listener);

    }
}
