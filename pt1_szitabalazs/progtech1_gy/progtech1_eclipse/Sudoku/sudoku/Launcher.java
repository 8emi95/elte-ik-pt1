package sudoku;

import sudoku.model.SudokuEngine;
import sudoku.view.SudokuFrame;

public class Launcher {
    public static void main(String[] args) {
        SudokuEngine engine = new SudokuEngine();
        SudokuFrame frame = new SudokuFrame();
        engine.setView(frame);
        //frame.setView(engine);
        engine.startNewGame();
        frame.showFrame();
    }
}
