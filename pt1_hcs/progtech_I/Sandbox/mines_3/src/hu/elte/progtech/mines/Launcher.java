package hu.elte.progtech.mines;

import hu.elte.progtech.mines.model.MinesEngine;
import hu.elte.progtech.mines.view.MinesFrame;

public class Launcher {

	public static void main(String[] args) {
		MinesEngine engine = new MinesEngine();
		MinesFrame frame = new MinesFrame(engine);
		engine.startGame();
		frame.showFrame();
	}

}
