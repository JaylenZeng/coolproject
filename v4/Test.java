public class Test {
    public static void main(String[] args) {
        Line line = new Line();
        int cursor = 0;
        // line.insertChar(cursor, "a");
        // cursor ++;
        // line.insertChar(cursor, "b");
        // cursor ++;
        // System.out.println(line.previewChar(cursor, "|"));
        // cursor --;
        // line.backspace(cursor);
        // cursor --;
        // System.out.println(line.previewChar(cursor, "|"));

        Notebook nb = new Notebook();
        nb.type("a");
        nb.type("b");
        nb.cursorPos[1]--;
        nb.type("i");

        nb.enter();

        
        System.out.println(nb);


    }
}
