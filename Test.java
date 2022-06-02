public class Test {

    public static void main(String[] args) {
        Line l = new Line();

        l.insertChar(0,'a');
        l.insertChar(1,'b');
        l.insertChar(2,'c');
        l.insertChar(3,'d');
        l.insertChar(4,'e');
        l.insertChar(5,'f');
        l.backspace(6);
        System.out.println(l);

        l.backspace(4);
        System.out.println(l);

        l.backspace(3);

        System.out.println(l);
        
    }


}
