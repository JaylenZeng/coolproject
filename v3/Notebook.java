import java.util.ArrayList;

public class Notebook{
    ArrayList<Line> notebook;
    String title;
    int[] cursorPos;
    public Notebook() {
        notebook = new ArrayList<Line>();
        title = "Untitled Notebook";
    }

    public Notebook(String title) {
        this();
        this.title = title;
    }

    public void writeLine(String s) {
        notebook.add(cursorPos[0], new Line(s));
        cursorPos[0]++;
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
        return notebook.get(line).getText();
    }

    public void moveCursor(int row, int col) {
        if (cursorPos[0]+row >= 0 && cursorPos[0]+row <= notebook.size())
            cursorPos[0] += row;

        if (cursorPos[1]+col >= 0 && cursorPos[1]+col <= getLineContent(cursorPos[0]).length())
            cursorPos[0] += col;
    }

    public ArrayList getNotebook() {
        return notebook;
    }
    
    public String toString() { // to be limited to n lines
        String ret = title+"\n";
        int[] bounds = justify(cursorPos[0], notebook.size()-1, 10);

        for(int i = bounds[0]; i <= bounds[1]; i++) {
            if (cursorPos[0] == i) {
                notebook.get(i).previewChar(cursorPos[1], "|");
            }
            else ret += getLineContent(i);
        }
        return ret;
    }
}