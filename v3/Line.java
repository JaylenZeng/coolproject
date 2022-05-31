public class Line{
    String content;
    int linkIndex;
    
    public Line() {
        content = "";
        linkIndex = 0;
    }
    
    public Line(String content) {
        this.content = content;
    }

    public String getText() {
        return content;
    }

    public void setLink(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public int getLinkIndex() {
        return linkIndex;
    }

    public String previewChar(int index, String character) {
        return content.substring(0,index) + character + content.substring(index);
    }

    public void insertChar(int index, String character) {
        content = previewChar(index, character);
    }
}
