import java.util.ArrayList;

public class Notebook{
    ArrayList<Line> notebook;
    String title;
    // int[][] cursorPos;
    public Notebook() {
        notebook = new ArrayList<Line>();
        title = "Untitled Notebook";
    }

    public Notebook(String title) {
        this();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void writeLine(String s) {
        notebook.add(new Line(s));
    }

    
    public String toString() { // to be limited to n lines
        //TODO title is stickied
        String ret = "";
        for (Line l : notebook) {
            ret += l.getContent() + "\n";   
        }
        return ret;
    }
}