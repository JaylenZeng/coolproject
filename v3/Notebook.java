import java.util.ArrayList;

public class Notebook{
    ArrayList<Line> notebookArray;
    String title;
    int[] cursorPos;
    boolean changed;

    public Notebook() {
        notebookArray = new ArrayList<Line>();
        title = "Untitled Notebook";
        cursorPos = new int[2];
        changed = true;
    }

    public Notebook(String title) {
        this();
        this.title = title;
    }

    public boolean changed() {
        if (changed == true) {
            changed = false;
            return true;
        }
        return false;
    }

    public void writeLine(String s) {
        notebookArray.add(cursorPos[0], new Line(s));
        cursorPos[0]++;
        changed = true;
    }

    public void enter() {
        writeLine("");
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

    public String getLineContent(int line) {
        return notebookArray.get(line).getText();
    }

    public void moveCursor(int row, int col) {
        if (cursorPos[0]+row >= 0 && cursorPos[0]+row <= notebookArray.size())
            cursorPos[0] += row;

        if (cursorPos[1]+col >= 0 && cursorPos[1]+col <= getLineContent(cursorPos[0]).length())
            cursorPos[0] += col;
        changed = true;
        
    }

    public ArrayList<Line> getNotebookArray() {
        return notebookArray;
    }
    
    public String toString() {
        String ret = title+"\n";
        int[] bounds = justify(cursorPos[0], notebookArray.size()-1, 10);

        for(int i = bounds[0]; i <= bounds[1]; i++) {
            if (cursorPos[0] == i) {
                notebookArray.get(i).previewChar(cursorPos[1], "|");
            }
            else ret += getLineContent(i);
        }
        return ret;
    }
}