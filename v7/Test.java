import java.awt.Frame;

public class Test {

    public static void sleep(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Frame f;
    public static void main(String[] args) {
        f = new Frame("KTNBK");
        f.setSize(200,50);
        f.setVisible(true);

        Notebook nb = new Notebook("kit1"+"\n");
        Action.clearScreen();
        System.out.println(nb);
        
        TestKeyListener listener = new TestKeyListener(f);
        f.addKeyListener(listener);
        System.out.println("yay!!!");
    }


}
