import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.time.format.DateTimeFormatter;
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
}