import java.awt.Frame;


public class Woo {

    public static void main(String[] args) {
        Frame f = new Frame("KTNBK");
        f.setSize(200,50);
        f.setVisible(true);

        Notebook nb = new Notebook("kit1");
        Action.clearScreen();
        System.out.println(nb);
        KittenKeyListener listener = new KittenKeyListener(nb);
        f.addKeyListener(listener);
    }
}
