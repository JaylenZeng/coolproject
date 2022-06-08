
public class Action {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void process(int input, Notebook nb) {

        if (input == 17) { // ctrl
            Command.prompt(nb);
        }
        if (input == 37) { // left
            nb.moveCursor(0, -1);
        }
        if (input == 38) { // up
            nb.moveCursor(-1, 0);
        }
        if (input == 39) { // right
            nb.moveCursor(0, 1);
        }
        if (input == 40) { // down
            nb.moveCursor(1, 0);
        }

        if (input == 10) { // enter
            nb.enter();
        }
        if (input == 8) { // backspace
            if (nb.cursorPos[1] == 0) { // cannot combine booleans because if-else dep on this condition
                
                if (nb.cursorPos[0] != 0){
                    nb.moveCursor(-1, 10000);
                    nb.nbAL.get(nb.cursorPos[0]).insertString(nb.cursorPos[1], nb.nbAL.get(nb.cursorPos[0]+1).toString());
                    nb.nbAL.remove(nb.cursorPos[0]+1);
                }
            }
            // :D
            else {
                nb.getCurrentLine().backspace(nb.cursorPos[1]);
                nb.moveCursor(0,-1);
            }
        }
    }


    public static void wrap (int lineNum, Notebook nb, int lineLength) {
        Line currentLine = nb.getLine(lineNum);
        if (currentLine.length() <= lineLength) return;
        String extra = nb.getLine(lineNum).partition(nb.currentWidth()-1);
        
        if (nb.cursorPos[0] == nb.height() - 1) { //last line 
            nb.nbAL.add(nb.cursorPos[0] + 1, new Line());
            nb.moveCursor(1, 0);
        }
        nb.getLine(lineNum + 1).insertChar(0, extra.charAt(0));
        if (nb.cursorPos[1] == nb.currentWidth()) {
            nb.moveCursor(1, -10000);
        }
        // else {
        //     nb.moveCursor(0, 1); created weird bugs where cursor would move two spaces in specific cases. Fixed this issue by moving cursor in type method.
        // }
        wrap(lineNum+1, nb, lineLength);

    }

    public static void type(char input, Notebook nb, int lineLength) {
        nb.nbAL.get(nb.cursorPos[0]).insertChar(nb.cursorPos[1], input);
        if (nb.getCurrentLine().length() > lineLength-1) {
            wrap(nb.cursorPos[0], nb, lineLength);
            nb.moveCursor(0, 1); 
        }
        else {
            nb.moveCursor(0, 1);
        }
        // i put moveCursor in the if statement so it will only do it once no matter what. 
    }

    public static void invokeCommand(String cmd, Notebook nb) {
        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < cmd.length(); j++) {
                Action.type(cmd.charAt(j), nb, 80); //TODO set
            }
        }
        Woo.listener.refresh(); //debug
    }
}
