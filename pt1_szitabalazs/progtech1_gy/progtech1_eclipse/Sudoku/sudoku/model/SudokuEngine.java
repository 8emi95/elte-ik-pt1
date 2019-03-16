package sudoku.model;

import sudoku.view.SudokuFrame;

public class SudokuEngine {
    private static final int SIZE = 9;
    private SudokuFrame view;

    public void setView(SudokuFrame view) {
        this.view = view;    
    }

    public void startNewGame() {
        // TODO Auto-generated method stub
    }

    public int getSize() {
        return SIZE;
    }

}
