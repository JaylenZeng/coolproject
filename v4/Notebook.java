import java.util.ArrayList;

public class Notebook{
    ArrayList<Line> notebookArray;
    String title;
    public int[] cursorPos;
    boolean changed;

    public Notebook() {
        notebookArray = new ArrayList<Line>();
        notebookArray.add(new Line(""));
        cursorPos = new int[2];
        changed = true;
        title = "Untitled Notebook";
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

    public int height() {
        return notebookArray.size();
    }

    public int width(int i) {
        return notebookArray.get(i).getText().length();
    }

    public int curWidth() {
        return width(cursorPos[0]);
    }

    public void enter() {
        String left = getLineText(cursorPos[0]).substring(0,cursorPos[1]);
        String right = getLineText(cursorPos[0]).substring(cursorPos[1]);
        notebookArray.get(cursorPos[0]).setText( left );
        notebookArray.add(cursorPos[0], new Line(right));
    }

    public void type(String character) { // tested
        notebookArray.get(cursorPos[0]).insertChar(cursorPos[1], character);
        cursorPos[1]++;
    }

    public int[] justify(int pos, int maxIndex, int radius) { // tested
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

    public String getLineText(int line) { // tested
        return notebookArray.get(line).getText();
    }

    public void moveCursor(int row, int col) {
        int newRow = cursorPos[0]+row;
        int newCol = cursorPos[1]+col;
        changed = true;
        if (row != 0 && newRow >= 0 && newRow <= height())
            cursorPos[0] = newRow;
        else if (col != 0 && newCol >= 0 && newCol <= curWidth())
            cursorPos[1] = newCol;
        else changed = false;
    }

    public String toString() {
        String ret = title+"\n";
        // int[] bounds = justify(cursorPos[0], notebookArray.size()-1, 10);

        // for(int i = bounds[0]; i <= bounds[1]; i++) {
        for (int i = 0; i < notebookArray.size(); i++) {

            if (cursorPos[0] == i) {
                ret += notebookArray.get(i).previewChar(cursorPos[1], "|");
            }
            else {
                ret += getLineText(i) + "\n";
            }
        }
        return ret.substring(0,ret.length());
    }
}