import java.awt.Frame;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void sleep(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void pemdas(String s) {
        Stack<String> normal = new Stack<String>();
        Stack<String> paren = new Stack<String>();
        String[] array = s.split("\\(|\\)-|\\*|\\+|\\/|\\^");
        for (String str : array) {
            System.out.println(str);
        }
    }





    public static Frame f;
    public static void main(String[] args) {
        // Line a = new Line();
        // a.insertString(0, "hello");
        // a.insertString(5, "ivi");
        // System.out.println(a);
        pemdas("23-3*(1-3^4)+14/4");
    }


}
