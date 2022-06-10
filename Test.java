import java.awt.Frame;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

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

    public static void sort(String dir) {
        String curLine = "d deezs";
        String[] elements = curLine.split("[\\s,]+");

        PriorityQueue<String> alphabet;
        PriorityQueue<Integer> numerical;
        if (dir.equals("min")) {
            alphabet = new PriorityQueue<String>(new Comparator<String>() {
                public int compare(String one, String two) {
                    String[] a = one.toLowerCase().split("");
                    String[] b = two.toLowerCase().split("");
                    for (int i = 0; i < Math.min(a.length, b.length); i++) {
                    System.out.println("1: "+(int) a[i].charAt(0)+" 2: "+(int) b[i].charAt(0));

                        if ((int) a[i].charAt(0) < (int) b[i].charAt(0)) return -1;
                        if ((int) a[i].charAt(0) > (int) b[i].charAt(0)) return 1;
                    }
                    System.out.println("reached");
                    if (b.length < a.length) return 1;
                    return -1; 
                }
            });
            numerical = new PriorityQueue<>();
        }
        else {
            alphabet = new PriorityQueue<>(new Comparator<String>() {
                public int compare(String two, String one) {
                    String[] a = one.toLowerCase().split("");
                    String[] b = two.toLowerCase().split("");

                    for (int i = 0; i < Math.min(a.length, b.length); i++) {
                        if ((int) a[i].charAt(0) < (int) b[i].charAt(0)) return -1;
                        if ((int) a[i].charAt(0) > (int) b[i].charAt(0)) return 1;
                    }
                    if (b.length < a.length) return -1;
                    return 1; 
                }
            });
            numerical = new PriorityQueue<>(Comparator.reverseOrder());
        }

        int numLength = 0;
        int alphaLength = 0;
        for (String element : elements) {
            int firstChar = (int) element.toLowerCase().charAt(0);
            if (firstChar >= 48 && firstChar <=57) {
                numerical.add(Integer.parseInt(element));
                numLength++;
                
            }
            if (firstChar >= 97 && firstChar <=122) {
                alphabet.add(element);
                alphaLength++;
            }
        }

        for (int i = 0; i < alphaLength; i++) {
            String a="";
            for (String character : alphabet) {
                a = character;
                break;
            }
            System.out.print(a + " ");
            alphabet.remove(a);
        }

        for (int i = 0; i < numLength; i++) {
            int a=0;
            for (int num : numerical) {
                a=num;
                break;
            }
            System.out.print(a + " ");
            numerical.remove(a);
        }
    }





    public static Frame f;
    public static void main(String[] args) {
        // Line a = new Line();
        // a.insertString(0, "hello");
        // a.insertString(5, "ivi");
        // System.out.println(a);
        // pemdas("23-3*(1-3^4)+14/4");
        sort("min");
    }


}
