public class Line{
    String content;
    // int linkIndex;
    
    public Line() {
        content = "";
        // linkIndex = 0;
    }
    
    public Line(String content) {
        this();
        this.content = content;
    }

    // public void setLink(int linkIndex) {
    //     this.linkIndex = linkIndex;
    // }

    // public int getLinkIndex() {
    //     return linkIndex;
    // }
    
    public String previewChar(int index, char character) { // tested
        return content.substring(0,index) + (""+character) + content.substring(index);
    }

    public void insertChar(int index, char character) { // tested
        content = previewChar(index, character);
    }

    public void insertString(int index, String s) {
        content = content.substring(0, index) + s + content.substring(index);
    }

    public void backspace(int index) { // tested; removes char2 at index-1
        // String add = "";
        // if (index < content.length()) add = content.substring(index);
        // content = content.substring(0,index-1) + add;

        content = content.substring(0,index-1) + content.substring(index);

    }

    public String partition(int cPos) {
        String s = content.substring(cPos);
        content = content.substring(0,cPos);
        return s;
    }

    public String peek(int begin, int end) {
        if (end > length()) return content.substring(begin);
        return content.substring(begin,end);
    }

    public boolean isEmpty() {
        return content.length() == 0;
    }

    public int length() {
        return content.length();
    }

    public String toString() {
        return content;
    }
}
