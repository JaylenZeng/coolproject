import java.util.ArrayList;

public class Notebook {
    public ArrayList<Line> nbAL;
    String title;
    public int[] cursorPos;

    public Notebook() {
        nbAL = new ArrayList<Line>();
        nbAL.add(new Line(""));
        title = "Untitled Notebook";
        cursorPos = new int[2];
    }

    public Notebook(String title) {
        this();
        this.title = title;
    }

    public Line getCurrentLine() {
        return nbAL.get(cursorPos[0]);
    }

    public int height() {
        return nbAL.size();
    }

    public int width(int i) {
        return nbAL.get(i).toString().length();
    }

    public int currentWidth() {
        return width(cursorPos[0]);
    }

    public int[] justify(int pos, int maxIndex, int radius) { // tested
        maxIndex--;
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
    
    public void moveCursor(int dRow, int dCol) {
        int nRow = cursorPos[0] + dRow;
        int nCol = cursorPos[1] + dCol;
        if (nRow >= height()) nRow = height()-1;
        if (nRow < 0) nRow = 0;
        if (nCol >= currentWidth()) nCol = currentWidth();
        if (nCol < 0) nCol = 0;

        cursorPos = new int[]{nRow,nCol}; // modifying array directly works too
    }

    public void enter() {
        
    }

    public String toString() {
        String ret = title+"\n";
        int[] bounds = justify(cursorPos[0], nbAL.size(), 10);

        for(int i = bounds[0]; i <= bounds[1]; i++) {
        // for (int i = 0; i < nbAL.size(); i++) {
            if (i == cursorPos[0]) {
                ret+= nbAL.get(i).previewChar(cursorPos[1], '|')+"\n";
            }
            else ret+=nbAL.get(i).toString()+"\n";
        }
        return ret.substring(0,ret.length());
    }
}
