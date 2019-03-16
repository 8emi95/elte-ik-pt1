package mastermind;

import mastermind.model.MastermindEngine;
import mastermind.view.MastermindFrame;

public class Launcher {
    public static void main(String[] args) {
        MastermindEngine engine = new MastermindEngine();
        MastermindFrame frame = new MastermindFrame();
        frame.setModel(engine);
        engine.setView(frame);
        engine.startNewGame();
        frame.showFrame();
    }
}
