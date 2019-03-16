package hu.elte.prt.numbers;

import hu.elte.prt.numbers.gui.NumbersFrame;
import hu.elte.prt.numbers.model.NumbersEngine;

public class Launcher {

    public static void main(String args[]) {
	NumbersEngine engine = new NumbersEngine();
	NumbersFrame frame = new NumbersFrame(engine);
	engine.setGUI(frame);
	engine.newGame(5);
	frame.showFrame();
    }
}
