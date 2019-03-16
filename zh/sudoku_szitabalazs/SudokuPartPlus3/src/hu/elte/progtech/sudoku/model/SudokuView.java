package hu.elte.progtech.sudoku.model;

public interface SudokuView {

	void newGame();

	void updateFields();

	void invalidField(int row, int column);

	void completed();

	void updateTime(int currentTime);

}
