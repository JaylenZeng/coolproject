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

        }
        if (input == 8) { // backspace
            nb.getCurrentLine().backspace(nb.cursorPos[1]);
            nb.moveCursor(0, -1);
        }
    }

    public static void type(char input, Notebook nb) {
        nb.nbAL.get(nb.cursorPos[0]).insertChar(nb.cursorPos[1], input);
        nb.cursorPos[1]++;
    }
}
