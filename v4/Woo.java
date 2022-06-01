// import java.util.Scanner;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class Woo {

    public static void clearScreen() {
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
        
        // Scanner in = new Scanner(System.in);
        Notebook nb = new Notebook("testing 123");
        KittenKeyListener keyListener = new KittenKeyListener(nb);
            nb = keyListener.returnNotebook(); //applies all changes made by KeyListener
            f.addKeyListener(keyListener);
        
        int tmpctr=0;
        while (true) {
            if (nb.changed()) {
                clearScreen();
                System.out.println("changed!" + ++tmpctr);
                System.out.print(nb);
                // nb.writeLine(in.nextLine());

            }
        }
        // in.close();
    }
}
