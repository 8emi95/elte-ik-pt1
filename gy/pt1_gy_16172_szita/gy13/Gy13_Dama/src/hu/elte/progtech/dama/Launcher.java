package hu.elte.progtech.dama;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import hu.elte.progtech.dama.model.CheckersEngine;
import hu.elte.progtech.dama.view.CheckersFrame;

public class Launcher {

	public static void main(String[] args) {

		CheckersEngine engine = new CheckersEngine();
		CheckersFrame frame = new CheckersFrame(engine);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("Checkers");
		frame.setVisible(true);
	}

}
