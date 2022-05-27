public class Line{
    String content;
    int linkIndex;
    
    public Line() {
        content = "";
        linkIndex = 0;
    }

    public String getText() {
        return content;
    }

    public Line(String content) {
        this.content = content;
    }

    public void setLink(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public int getLinkIndex() {
        return linkIndex;
    }

    public String getContent() {
        return content;
    }
}
