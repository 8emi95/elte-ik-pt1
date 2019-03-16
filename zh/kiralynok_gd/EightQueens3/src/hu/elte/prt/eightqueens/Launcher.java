package hu.elte.prt.eightqueens;

import hu.elte.prt.eightqueens.model.Engine;
import hu.elte.prt.eightqueens.view.Frame;

public class Launcher {

    public static void main(String[] args) {
	Engine engine = new Engine();
	Frame frame = new Frame(engine);
	engine.startNewGame();
	frame.showFrame();
    }
}
