package hu.elte.progtech.sudoku.model;

import java.util.Timer;
import java.util.TimerTask;

public class SudokuEngine {

	private static final int SIZE = 9;

	private SudokuView view;
	private FieldValue[][] values;
	private int elapsedSeconds;
	private Timer timer;

	public void setView(SudokuView view) {
		this.view = view;
	}

	public void startNewGame() {
		elapsedSeconds = 0;
		view.updateTime(elapsedSeconds);
		configurateTimer();
		values = new FieldValue[SIZE][SIZE];
		initializeValues();
		updateView();
	}

	private void configurateTimer() {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				view.updateTime(++elapsedSeconds);
			}
		}, 1000, 1000);
	}

	private void initializeValues() {
		setPredefinedValues();
		setOtherValues();
	}

	private void setPredefinedValues() {
		values[0][2] = new FieldValue(6, true);
		values[0][4] = new FieldValue(5, true);
		values[0][5] = new FieldValue(4, true);
		values[0][6] = new FieldValue(9, true);
		values[1][0] = new FieldValue(1, true);
		values[1][4] = new FieldValue(6, true);
		values[1][7] = new FieldValue(4, true);
		values[1][8] = new FieldValue(2, true);
		values[2][0] = new FieldValue(7, true);
		values[2][4] = new FieldValue(8, true);
		values[2][5] = new FieldValue(9, true);
		values[3][1] = new FieldValue(7, true);
		values[3][5] = new FieldValue(5, true);
		values[3][7] = new FieldValue(8, true);
		values[3][8] = new FieldValue(1, true);
		values[4][1] = new FieldValue(5, true);
		values[4][3] = new FieldValue(3, true);
		values[4][4] = new FieldValue(4, true);
		values[4][6] = new FieldValue(6, true);
		values[5][0] = new FieldValue(4, true);
		values[5][2] = new FieldValue(2, true);
		values[6][1] = new FieldValue(3, true);
		values[6][2] = new FieldValue(4, true);
		values[6][6] = new FieldValue(1, true);
		values[7][0] = new FieldValue(9, true);
		values[7][3] = new FieldValue(8, true);
		values[7][7] = new FieldValue(5, true);
		values[8][3] = new FieldValue(4, true);
		values[8][6] = new FieldValue(3, true);
		values[8][8] = new FieldValue(7, true);
	}

	private void setOtherValues() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (values[i][j] == null) {
					values[i][j] = new FieldValue(0, false);
				}
			}
		}
	}

	private void updateView() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				view.update(i, j, values[i][j].getValue());
			}
		}
	}

	public void changeValue(int row, int column) {
		if (!isPredefined(row, column)) {
			incrementValue(row, column);
			view.update(row, column, values[row][column].getValue());
			checkCompletion();
		}
	}

	public boolean isPredefined(int row, int column) {
		return values[row][column].isPredefined();
	}

	private void incrementValue(int row, int column) {
		if (values[row][column].getValue() == SIZE) {
			values[row][column].setValue(1);
		} else {
			values[row][column].incrementValue();
		}
	}

	private void checkCompletion() {
		if (isCompleted()) {
			if (timer != null) {
				timer.cancel();
			}
			view.completed();
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
		return values[row][column].getValue() != 0 && isUnique(row, column);
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
		return values[row][column].equals(values[otherRow][otherColumn]);
	}

	public int getSize() {
		return SIZE;
	}

	public int getBlockSize() {
		return (int) Math.sqrt(SIZE);
	}

	public int getValue(int row, int column) {
		return values[row][column].getValue();
	}

	public void clearValue(int row, int column) {
		if (!isPredefined(row, column)) {
			values[row][column].setValue(0);
			view.update(row, column, values[row][column].getValue());
		}
	}

}
