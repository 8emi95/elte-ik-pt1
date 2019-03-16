package hu.elte.progtech.sudoku.model;

public class SudokuEngine {

	private static final int SIZE = 9;

	private SudokuView view;
	private int[][] values;

	public void setView(SudokuView view) {
		this.view = view;
	}

	public void startNewGame() {
		values = new int[SIZE][SIZE];
		populateInitialValues();
		updateView();
	}

	private void populateInitialValues() {
		values[0][2] = 6;
		values[0][4] = 5;
		values[0][5] = 4;
		values[0][6] = 9;
		values[1][0] = 1;
		values[1][4] = 6;
		values[1][7] = 4;
		values[1][8] = 2;
		values[2][0] = 7;
		values[2][4] = 8;
		values[2][5] = 9;
		values[3][1] = 7;
		values[3][5] = 5;
		values[3][7] = 8;
		values[3][8] = 1;
		values[4][1] = 5;
		values[4][3] = 3;
		values[4][4] = 4;
		values[4][6] = 6;
		values[5][0] = 4;
		values[5][2] = 2;
		values[6][1] = 3;
		values[6][2] = 4;
		values[6][6] = 1;
		values[7][0] = 9;
		values[7][3] = 8;
		values[7][7] = 5;
		values[8][3] = 4;
		values[8][6] = 3;
		values[8][8] = 7;
	}

	private void updateView() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				view.update(i, j, values[i][j]);
			}
		}
	}

	public int getSize() {
		return SIZE;
	}

	public int getBlockSize() {
		return (int) Math.sqrt(SIZE);
	}

	public void changeValue(int row, int column) {
		incrementValue(row, column);
		view.update(row, column, values[row][column]);
	}

	private void incrementValue(int row, int column) {
		if (values[row][column] == SIZE) {
			values[row][column] = 1;
		} else {
			++values[row][column];
		}
	}

	public int getValue(int row, int column) {
		return values[row][column];
	}

}
