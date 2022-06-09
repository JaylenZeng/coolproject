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
        Line a = new Line();
        a.insertString(0, "hello");
        a.insertString(5, "ivi");
        System.out.println(a);
    }


}
