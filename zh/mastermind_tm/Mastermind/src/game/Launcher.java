package game;

import game.model.MastermindEngine;
import game.view.MastermindFrame;


public class Launcher {
    public static void main(String[] args) {
        MastermindEngine engine = new MastermindEngine();
        engine.startNewGame();
        MastermindFrame frame = new MastermindFrame(engine);
        frame.showFrame();

    }
}
