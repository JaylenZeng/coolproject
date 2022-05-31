import java.util.Scanner;
import java.awt.Frame;
import java.awt.Label;

public class Woo {

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){
        //GUI STUFF
        Frame f = new Frame("test");
        f.setSize(200,200);
        Label l = new Label();
        l.setText("KTNBK");
        f.add(l);
        f.setVisible(true);
        
        //Scanner in = new Scanner(System.in);
        Notebook nb = new Notebook("testing 123");
        KittenKeyListener k = new KittenKeyListener(nb);
        f.addKeyListener(k);
        
        while (true) {
            clearScreen();
            System.out.print(nb);
            //nb.writeLine(in.nextLine())
            nb = k.returnNotebook(); //applies all changes made by KeyListener
        }
        // in.close();
    }
}
