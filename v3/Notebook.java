import java.util.ArrayList;

public class Notebook{
    ArrayList<Line> notebook;
    String title;
    int cursorPos;
    public Notebook() {
        notebook = new ArrayList<Line>();
        title = "Untitled Notebook";
    }

    public Notebook(String title) {
        this();
        this.title = title;
    }

    public void writeLine(String s) {
        notebook.add(cursorPos, new Line(s));
        cursorPos++;
    }

    public int[] justify(int pos, int maxIndex, int radius) {
        int lowbound = pos-radius;
        int highbound = pos+radius;
        if (highbound > maxIndex) {
            highbound = maxIndex;
        }
        if (lowbound < 0) {
            lowbound = 0;
        }
        return new int[]{lowbound,highbound};
    }

    public int getCursorPos() {
        return cursorPos;
    }
    public void setCursorPos(int pos) {
        cursorPos = pos;
    }

    public ArrayList getNotebook() {
        return notebook;
    }
    
    public String toString() { // to be limited to n lines
        String ret = title+"\n";
        int[] bounds = justify(cursorPos, notebook.size()-1, 10);

        for(int i = bounds[0]; i <= bounds[1]; i++) {
            if (i == cursorPos-1) {
                ret += notebook.get(i).getText() + "|" /*temp cursor*/;
            }
            else {
                ret += notebook.get(i).getText(); 
            }
        }
        return ret;
    }
}