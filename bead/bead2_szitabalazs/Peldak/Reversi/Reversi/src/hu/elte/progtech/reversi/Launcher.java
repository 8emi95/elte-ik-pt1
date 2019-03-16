package hu.elte.progtech.reversi;

import hu.elte.progtech.reversi.model.ReversiEngine;
import hu.elte.progtech.reversi.view.ReversiFrame;

public class Launcher {

	public static void main(String[] args) {
		ReversiEngine engine = new ReversiEngine();
		ReversiFrame frame = new ReversiFrame();
		engine.setView(frame);
		frame.setModel(engine);
		frame.showFrame();
		engine.startNewGame();
	}
	
}
