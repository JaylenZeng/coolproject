import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileReader;

public class Woo {
    public static Frame f;
    static Notebook nb;
    public static KittenKeyListener listener;


    public static void main(String[] args) {
        String title = "Untitled";
        BufferedReader reader;

        try {
            title = args[0];
        }
        catch (Exception e) {}
        nb = new Notebook(title);

        try {
            reader = new BufferedReader(new FileReader("files/"+args[0]+".ktnbk"));
            String line;
            do {
                line = reader.readLine();
                if (line!= null) nb.nbAL.add(new Line(line));
            } while (line != null);
        }
        catch (Exception e) {
            System.out.println("No file found, creating new ktnbk");
            Util.sleep(2);
            nb.nbAL.add(new Line());
        }

        listener = new KittenKeyListener(nb);


        f = new Frame("KTNBK");
        f.setSize(250, 0);
        f.setVisible(true);

        f.addKeyListener(listener);

    }
}
