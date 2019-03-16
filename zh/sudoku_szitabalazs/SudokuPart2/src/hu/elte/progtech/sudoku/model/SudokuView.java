package hu.elte.progtech.sudoku.model;

public interface SudokuView {

	void update(int row, int column, int value);

	void completed();
}
