package hu.elte.progtech.queens;

import hu.elte.progtech.queens.model.QueensEngine;
import hu.elte.progtech.queens.view.QueensFrame;

public class Launcher {

	public static void main(String[] args) {
		QueensEngine engine = new QueensEngine();
		QueensFrame frame = new QueensFrame(engine);
		
		engine.startGame();
		frame.showFrame();
		
	}

}
