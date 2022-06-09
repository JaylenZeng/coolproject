
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


    public static void wrap (Notebook nb) {
        //in short, this version of wrap iterates through every line of the Notebook. If that line surpasses the lineLength, it fixes it. 
        for (int i = 0; i < nb.height(); i++) {
            boolean hasAddLine = false; //fixes cursorPos issue
            if (nb.getLine(i).length() > Params.lineLength) {
                //isolates extra characters
                int overflow = nb.currentWidth()-Params.lineLength; //number of characters surpassing lineLength
                String extra = nb.getLine(i).partition(nb.currentWidth() - overflow); //stores those characters
                
                //checks if we need to add a new line
                if (i == nb.height() -1 ) {
                    hasAddLine = true;
                    nb.nbAL.add(i+1, new Line());
                    nb.moveCursor(1, -10000);
                    nb.cursorPos[1] = 1;
                }

                if (nb.cursorPos[1] > nb.currentWidth() && !hasAddLine) { //handles case where user is typing at the end of a line but next line exists. 
                    nb.moveCursor(1, -10000);
                }
                nb.getLine(i + 1).insertString(0, extra); //inserts extra characters
            }
        }
    }


    public static void type(char input, Notebook nb) {
        nb.nbAL.get(nb.cursorPos[0]).insertChar(nb.cursorPos[1], input);
        nb.moveCursor(0, 1);
    }

    public static void invokeCommand(String cmd, Notebook nb) {
        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < cmd.length(); j++) {
                Action.type(cmd.charAt(j), nb); //TODO set
            }
        }
        Woo.listener.refresh(); //debug
    }
}
