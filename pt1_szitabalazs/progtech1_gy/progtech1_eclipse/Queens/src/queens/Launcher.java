package queens;

import queens.model.QueensEngine;
import queens.view.QueensFrame;

public class Launcher {
    public static void main(String[] args) {
        QueensEngine engine = new QueensEngine();
        QueensFrame frame = new QueensFrame(engine); // engine?
        engine.startNewGame();
        //frame.showFrame();
    }
}
