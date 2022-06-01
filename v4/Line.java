public class Line{
    String content;
    int linkIndex;
    
    public Line() {
        content = "";
        linkIndex = 0;
    }
    
    public Line(String content) {
        this();
        this.content = content;
    }

    public String getText() {
        return content;
    }

    public String setText(String s) {
        content = s;
        return content;
    }
    // public void setLink(int linkIndex) {
    //     this.linkIndex = linkIndex;
    // }

    // public int getLinkIndex() {
    //     return linkIndex;
    // }
    
    public String previewChar(int index, String character) { // tested
        return content.substring(0,index) + character + content.substring(index);
    }

    public void insertChar(int index, String character) { // tested
        content = previewChar(index, character);
    }

    public void backspace(int index) { // tested
        content = content.substring(0,index-1) + content.substring(index);
    }
}
