public class Command {
    public static void prompt(Notebook nb) {
        Notebook input = new Notebook("");
        input.nbAL.add(new Line(""));
        CmdKeyListener cmdKey = new CmdKeyListener(nb, input);
        cmdKey.refresh();
        Woo.f.removeKeyListener(Woo.listener);

        Woo.f.addKeyListener(cmdKey);
    }
}
// number lines
// help toggles label text
// set radius
// del line :)
// disp help in jframe
// set terminal cursor pos?
// pomodoro, hidetimer showtimer
// char count?
// eol