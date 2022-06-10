import java.awt.Frame;

public class Woo {
    public static Frame f;
    static Notebook nb;
    public static KittenKeyListener listener;


    public static void main(String[] args) {
        String title = "Untitled";
        try {
            title = args[0];
        }
        catch (Exception e) {}
        nb = new Notebook(title);
        listener = new KittenKeyListener(nb);


        f = new Frame("KTNBK");
        f.setSize(250, 0);
        f.setVisible(true);

        f.addKeyListener(listener);

    }
}
