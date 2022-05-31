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

    public void editText(char c ) {
        content += c;
    }

    public void setLink(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public int getLinkIndex() {
        return linkIndex;
    }
}
