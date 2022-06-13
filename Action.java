public class Action
{
    public static void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
    
    public static void process(int input, Notebook nb) {
        if (input == 17) {
            Command.prompt(nb);
        }
        if (input == 37) {
            nb.moveCursor(0, -1);
        }
        if (input == 38) {
            nb.moveCursor(-1, 0);
        }
        if (input == 39) {
            nb.moveCursor(0, 1);
        }
        if (input == 40) {
            nb.moveCursor(1, 0);
        }
        if (input == 10) {
            nb.enter();
        }
        if (input == 8) {
            if (nb.cursorPos[1] == 0) {
                if (nb.cursorPos[0] != 0) {
                    nb.moveCursor(-1, 10000);
                    nb.nbAL.get(nb.cursorPos[0]).insertString(nb.cursorPos[1], nb.nbAL.get(nb.cursorPos[0] + 1).toString());
                    nb.nbAL.remove(nb.cursorPos[0] + 1);
                }
            }
            else {
                nb.getCurrentLine().backspace(nb.cursorPos[1]);
                nb.moveCursor(0, -1);
            }
        }
    }
    
    public static void type(char c, Notebook nb) {
        nb.nbAL.get(nb.cursorPos[0]).insertChar(nb.cursorPos[1], c);
        nb.moveCursor(0, 1);
    }

    public static void typeString(String s, Notebook nb) {
        for(int i = 0; i < s.length(); i++) {
            Action.type(s.substring(i, i+1).charAt(0), nb);
        }
    }
    
    public static void invokeCommand(String input, Notebook nb) {
        String cmd = input.trim().toLowerCase();
        
        if (cmd.equals("help")) {
            Command.help();
        }
        if (cmd.indexOf("radius") != -1) {
            if (cmd.length() == 6) {
                Command.radius(10);
            }
            else if (cmd.indexOf("radius ") != -1) {
                Command.radius(Integer.parseInt(cmd.substring(cmd.indexOf(" ") + 1)));
            }
        }
        if (cmd.indexOf("width") != -1) {
            if (cmd.length() == 5) {
                Command.width(40);
            }
            else if (cmd.indexOf("width ") != -1) {
                Command.width(Integer.parseInt(cmd.substring(cmd.indexOf(" ") + 1)));
            }
        }
        if (cmd.indexOf("cat") != -1) {
            Command.cat();
        }
        if (cmd.indexOf("num") != -1) {
            Command.num();
        }
        if (cmd.indexOf("count") != -1) {
            Params.toggleCount = !Params.toggleCount;
        }
        if (cmd.indexOf("eol") != -1) {
            Command.eol(nb);
        }
        if (cmd.indexOf("save") != -1) {
            if (cmd.length() == 4) {
                Command.save(nb);
            }
            else if (cmd.indexOf("save ") != -1) {
                Command.save(cmd.substring(cmd.indexOf(" ") + 1), nb);
            }
        }
        if(cmd.indexOf("coin") != -1){
            Command.coin(nb);
        }
        if(cmd.indexOf("sort") != -1){
            if (cmd.length() == 4) Command.sort(nb, "min");
            else if (cmd.indexOf("sort ") != -1) {
                Command.sort(nb, cmd.substring(cmd.indexOf(" ")+1));
            }
        }
        Woo.listener.refresh();
    }
}