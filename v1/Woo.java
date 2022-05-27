import java.util.Scanner;
import java.awt.Frame;
import java.awt.Label;

public class Woo {

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Notebook nb = new Notebook("testing 123");
        while (true) {
            clearScreen();
            System.out.print(nb);
            nb.writeLine(in.nextLine());
        }
        // in.close();
    }
}
