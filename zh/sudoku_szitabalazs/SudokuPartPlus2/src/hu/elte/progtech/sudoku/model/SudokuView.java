package hu.elte.progtech.sudoku.model;

public interface SudokuView {

	void newGame();
	
	void update(int row, int column, int value);

	void completed();

	void updateTime(int currentTime);

}
