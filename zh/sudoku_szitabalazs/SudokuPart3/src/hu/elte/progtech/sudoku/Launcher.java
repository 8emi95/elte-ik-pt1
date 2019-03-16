package hu.elte.progtech.sudoku;

import hu.elte.progtech.sudoku.model.SudokuEngine;
import hu.elte.progtech.sudoku.view.SudokuFrame;

public class Launcher {

	public static void main(String[] args) {
		SudokuEngine engine = new SudokuEngine();
		SudokuFrame frame = new SudokuFrame();
		engine.setView(frame);
		frame.setModel(engine);
		engine.startNewGame();
		frame.showFrame();
	}

}
