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

	public void changeValue(int row, int column) {
		incrementValue(row, column);
		view.update(row, column, values[row][column]);
		if (isCompleted()) {
			view.completed();
		}
	}

	private void incrementValue(int row, int column) {
		if (values[row][column] == SIZE) {
			values[row][column] = 1;
		} else {
			++values[row][column];
		}
	}

	private boolean isCompleted() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (!isValid(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(int row, int column) {
		return values[row][column] != 0 && isUnique(row, column);
	}

	private boolean isUnique(int row, int column) {
		for (int i = 0; i < SIZE; ++i) {
			if (sameValueExistsInRow(row, column, i) || sameValueExistsInColumn(row, column, i)) {
				return false;
			}
		}
		return isUniqueInItsBlock(row, column);
	}

	private boolean sameValueExistsInRow(int row, int column, int i) {
		return i != column && sameValues(row, column, row, i);
	}

	private boolean sameValueExistsInColumn(int row, int column, int i) {
		return i != row && sameValues(row, column, i, column);
	}

	private boolean isUniqueInItsBlock(int row, int column) {
		int horizontalBlockIndex = row / getBlockSize();
		int verticalBlockIndex = column / getBlockSize();
		for (int i = 0; i < getBlockSize(); ++i) {
			for (int j = 0; j < getBlockSize(); ++j) {
				int horizontalIndex = horizontalBlockIndex * getBlockSize() + i;
				int verticalIndex = verticalBlockIndex * getBlockSize() + j;
				if (sameValueExistsInBlock(row, column, horizontalIndex, verticalIndex)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean sameValueExistsInBlock(int row, int column, int horizontalIndex, int verticalIndex) {
		return !sameIndex(row, column, horizontalIndex, verticalIndex)
				&& sameValues(row, column, horizontalIndex, verticalIndex);
	}

	private boolean sameIndex(int row, int column, int otherRow, int otherColumn) {
		return row == otherRow && column == otherColumn;
	}

	private boolean sameValues(int row, int column, int otherRow, int otherColumn) {
		return values[row][column] == values[otherRow][otherColumn];
	}

	public int getSize() {
		return SIZE;
	}

	public int getBlockSize() {
		return (int) Math.sqrt(SIZE);
	}

	public int getValue(int row, int column) {
		return values[row][column];
	}

}
