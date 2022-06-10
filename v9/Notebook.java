import java.util.ArrayList;

public class Notebook
{
    public ArrayList<Line> nbAL;
    String title;
    public int[] cursorPos;
    boolean primary;
    
    public Notebook() {
        nbAL = new ArrayList<Line>();
        title = "Untitled Notebook";
        cursorPos = new int[2];
        primary = true;
    }
    
    public Notebook(String title) {
        this();
        this.title = title;
    }
    
    public Notebook(String title, boolean primary) {
        this(title);
        this.primary = primary;
    }
    
    public Line getCurrentLine() {
        return getLine(cursorPos[0]);
    }
    
    public Line getLine(int index) {
        return nbAL.get(index);
    }
    
    public String getTitle() {
        return title;
    }
    
    public int height() {
        return nbAL.size();
    }
    
    public int width(int index) {
        return nbAL.get(index).toString().length();
    }
    
    public int currentWidth() {
        return width(cursorPos[0]);
    }
    
    public void moveCursor(int dRow, int dCol) {
        int nRow = cursorPos[0] + dRow;
        if (nRow >= height()) nRow = height()-1;
        if (nRow < 0) nRow = 0;

        int nCol = cursorPos[1] + dCol;
        if (nCol >= width(nRow)) nCol = width(nRow);
        if (nCol < 0) nCol = 0;

        cursorPos = new int[]{nRow,nCol}; // modifying array directly works too
    }
    
    public void enter() {
        nbAL.add(cursorPos[0] + 1, new Line(nbAL.get(cursorPos[0]).partition(cursorPos[1])));
        moveCursor(1, -10000);
    }
    
    public int[] bounds(int pos, int maxIndex, int wrapNum) {
        maxIndex--;
        int[] bounds = new int[]{ pos - Params.radius, pos + Params.radius };
        if (bounds[0] < 0) {
            bounds[1] += -1 * bounds[0];
        }
        else if (bounds[1] > maxIndex) {
            bounds[0] -= bounds[1] - maxIndex;
        }
        else {
            bounds[1] -= wrapNum;
        }
        if (bounds[0] < 0) {
            bounds[0] = 0;
        }
        else {
            bounds[0] += wrapNum;
        }
        if (bounds[1] > maxIndex) {
            bounds[1] = maxIndex;
        }
        return bounds;
    }
    
    public int wrapNum() {
        int n = 0;
        int[] bounds = bounds(cursorPos[0], nbAL.size(), 0);
        for (int i = bounds[0]; i <= bounds[1]; ++i) {
            n += getLine(i).length() / Params.lineLength;
        }
        return n;
    }
    
    @Override
    public String toString() {
        String ret = title;
        if (primary) {
            ret += " @ "+ cursorPos[0]+", "+cursorPos[1] + "\n";
        }
        int[] bounds = bounds(cursorPos[0], nbAL.size(), wrapNum());
        for (int i = bounds[0]; i <= bounds[1]; i++) {
            String lineNum = "";
            
            if (Params.dispLineNum && primary) {
                lineNum = i + " ";
            }
            Line line;
            if (i == cursorPos[0]) {
                line = new Line(getLine(i).previewChar(cursorPos[1], '|'));
            }
            else {
                line = new Line(getLine(i).toString());
            }
            for (int j = 0; j < getLine(i).length() / Params.lineLength + 1; j++) {
                if (j != 0 && Params.dispLineNum) {
                    lineNum = " ";
                    for(int a = 0; a < (i+"").length(); a++) {
                        lineNum += " ";
                    }
                }
                ret += lineNum + line.peek(j * Params.lineLength, (j + 1) * Params.lineLength)+"\n";
            }
        }
        return ret.substring(0, ret.length());
    }
}

//     public String toString() {
//         String ret = title;
//         int[] bounds = justify(cursorPos[0], nbAL.size());

//         for(int i = bounds[0]; i <= bounds[1]; i++) {
//             Line inserted;
//             if (i == cursorPos[0]) {
//                 inserted = new Line(getLine(i).previewChar(cursorPos[1], '|')); // this can be string if we move peek() to somewhere else or make it static
//             }
//             else {
//                 inserted = new Line(getLine(i).toString());
//             }
//             for (int j = 0; j < getLine(i).length() / Params.lineLength + 1; j++) {
//                 ret += inserted.peek(j*Params.lineLength, (j+1)*Params.lineLength)+"\n";
//             }
//         }
//         return ret.substring(0,ret.length());
//     }

// import java.util.ArrayList;

// public class Notebook {
//     public ArrayList<Line> nbAL;
//     String title;
//     public int[] cursorPos;
//     public int radius;

//     public Notebook() {
//         nbAL = new ArrayList<Line>();
//         nbAL.add(new Line(""));
//         title = "Untitled Notebook"+"\n";
//         cursorPos = new int[2];
//         radius = 10;
//     }

//     public Notebook(String title) {
//         this();
//         this.title = title;
//     }

//     public void setRadius(int rad) {
//         radius = rad;
//     }

//     public Line getCurrentLine() {
//         return getLine(cursorPos[0]);
//     }

//     public Line getLine(int index) {
//         return nbAL.get(index);
//     }

//     public int height() {
//         return nbAL.size();
//     }

//     public int width(int i) {
//         return nbAL.get(i).toString().length();
//     }

//     public int currentWidth() {
//         return width(cursorPos[0]);
//     }

//     public int[] justify(int pos, int maxIndex) { // tested
//         maxIndex--;
//         int lowbound = pos-radius;
//         int highbound = pos+radius;
//         if (lowbound < 0) {
//             lowbound = 0;
//             highbound += radius-pos;
//         }
//         if (highbound > maxIndex) {
//             highbound = maxIndex;
//         }

//         return new int[]{lowbound,highbound};
//     }
    
//     public void moveCursor(int dRow, int dCol) {
//         int nRow = cursorPos[0] + dRow;
//         if (nRow >= height()) nRow = height()-1;
//         if (nRow < 0) nRow = 0;

//         int nCol = cursorPos[1] + dCol;
//         if (nCol >= width(nRow)) nCol = width(nRow);
//         if (nCol < 0) nCol = 0;

//         cursorPos = new int[]{nRow,nCol}; // modifying array directly works too
//     }

//     public void enter() {
//         String nextLine = nbAL.get(cursorPos[0]).partition(cursorPos[1]);
//         nbAL.add(cursorPos[0]+1, new Line(nextLine));
//         moveCursor(1, -10000);
//     }

//     public String toString() {
//         String ret = title;
//         int[] bounds = justify(cursorPos[0], nbAL.size());

//         for(int i = bounds[0]; i <= bounds[1]; i++) {
//             Line inserted;
//             if (i == cursorPos[0]) {
//                 inserted = new Line(getLine(i).previewChar(cursorPos[1], '|')); // this can be string if we move peek() to somewhere else or make it static
//             }
//             else {
//                 inserted = new Line(getLine(i).toString());
//             }
//             for (int j = 0; j < getLine(i).length() / Params.lineLength + 1; j++) {
//                 ret += inserted.peek(j*Params.lineLength, (j+1)*Params.lineLength)+"\n";
//             }
//         }
//         return ret.substring(0,ret.length());
//     }
// }
