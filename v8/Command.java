import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.time.LocalDateTime;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Command
{
    static boolean helpEnabled;
    static JPanel p;
    static JLabel l;
    static JLabel c;
    static JLabel w;
    
    public static void prompt(Notebook nb) {
        Notebook input = new Notebook("", false);
        input.nbAL.add(new Line(""));
        CmdKeyListener cmdKey = new CmdKeyListener(nb, input);
        cmdKey.refresh();
        Woo.f.removeKeyListener(Woo.listener);
        Woo.f.addKeyListener(cmdKey);
    }
    
    public static void clear() {
        Woo.f.removeAll();
        Woo.f.repaint();
    }
    
    public static void help() {
        clear();
        if (!helpEnabled) {
            l = new JLabel("<html>help - displays all commands/closes screen<br/>clear - deletes all lines on notebook<br/>radius <n> - sets radius to n<br/>width <n> - sets max line length to n<br/>cat - DO IT<br/>count - returns total number of characters<br/>num - numbers each line<br/>eol - sets cursor at the end of the line<br/>save [filename] - saves notebook in files folder. <br/></html>");
            p = new JPanel();
            l.setFont(new Font("Comic Sans MS", 0, 12));
            l.setForeground(Color.BLUE);
            p.setLayout(new FlowLayout());
            p.add(l);
            Woo.f.add(p);
            Woo.f.setSize(400, 400);
        }
        else {
            Woo.f.setSize(250, 0);
        }
        helpEnabled = !helpEnabled;
    }
    
    public static void radius(int radius) {
        Params.radius = radius;
    }
    
    public static void width(int lineLength) {
        Params.lineLength = lineLength;
    }
    
    public static void num() {
        Params.dispLineNum = !Params.dispLineNum;
    }
    
    public static int count(Notebook nb) {
        int n = 0;
        for (int i = 0; i < nb.height(); ++i) { //iterate through every line
            n += nb.width(i);
        }
        return n;
    }
    
    public static void eol(Notebook nb) {
        nb.moveCursor(0, 10000);
    }
    
    public static void save(Notebook nb) {
        save(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd--HH-mm-ss")), nb);
    }
    
    public static void save(String s, Notebook nb) {
        File file = new File("files/"+s+".ktnbk");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter("files/"+s+".ktnbk");
            for (int i = 0; i < nb.height(); i++) {
                fileWriter.write(nb.getLine(i).toString() + "\n");
            }
            fileWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void coin(Notebook nb){
        nb.enter();
        String s;
        if (Math.random() >= .5) {
            s="heads";
        } else {
            s="tails";
        }
        for (int i = 0; i < s.length(); i++){
            Action.type(s.charAt(i), nb);
        }
        Woo.listener.refresh();


    }
    
    public static void cat() {
        clear();
        Command.c = new JLabel("<html><pre>      |\\      _,,,---,,_<br>ZZZzz /,`.-'`'    -.  ;-;;,_<br>     |,4-  ) )-,_. ,\\ (  `'-'<br>    '---''(_/--'  `-'\\_)</pre></html>");
        (Command.p = new JPanel()).add(Command.c);
        Woo.f.add(Command.p);
        Woo.f.setSize(250, 200);
    }

    public static void sort(Notebook nb, String dir) {
        String curLine = nb.getCurrentLine().toString();
        String[] elements = curLine.split("[\\s,]+");

        PriorityQueue<String> alphabet;
        PriorityQueue<Integer> numerical;
        if (dir.equals("min")) {
            alphabet = new PriorityQueue<String>(new Comparator<String>() {
                public int compare(String one, String two) {
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
        nb.enter();


        for (int i = 0; i < alphaLength; i++) {
            String a="";
            for (String character : alphabet) {
                a = character;
                break;
            }
            Action.typeString(a, nb);
            Action.type(' ', nb);
            alphabet.remove(a);
        }

        for (int i = 0; i < numLength; i++) {
            int a=0;
            for (int num : numerical) {
                a=num;
                break;
            }
            Action.typeString(a+"", nb);
            Action.type(' ', nb);
            numerical.remove(a);
        }
        Woo.listener.refresh();

    }
}