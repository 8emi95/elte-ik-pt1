package hu.elte.progtech.sudoku.model;

import java.util.Timer;
import java.util.TimerTask;

import hu.elte.progtech.sudoku.model.field.FieldValue;
import hu.elte.progtech.sudoku.model.field.ValueInitializer16x16;
import hu.elte.progtech.sudoku.model.field.ValueInitializer4x4;
import hu.elte.progtech.sudoku.model.field.ValueInitializer9x9;

public class SudokuEngine {

	private static final int[] AVAILABLE_SIZES = { 4, 9, 16 };
	private static final int DEFAULT_SIZE = AVAILABLE_SIZES[1];

	private SudokuView view;
	private int size;
	private FieldValue[][] values;
	private int elapsedSeconds;
	private Timer timer;

	public void setView(SudokuView view) {
		this.view = view;
	}

	public void startNewGame() {
		startNewGame(DEFAULT_SIZE);
	}

	public void startNewGame(int size) {
		this.size = size;
		initializeTimer();
		values = new FieldValue[size][size];
		initializeValues();
		view.newGame();
	}

	private void initializeTimer() {
		elapsedSeconds = 0;
		view.updateTime(elapsedSeconds);
		configurateTimer();
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
		if (size == 4) {
			new ValueInitializer4x4(values).initializeValues();
		} else if (size == 9) {
			new ValueInitializer9x9(values).initializeValues();
		} else if (size == 16) {
			new ValueInitializer16x16(values).initializeValues();
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
		if (values[row][column].getValue() == size) {
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
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
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
		for (int i = 0; i < size; ++i) {
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
		return size;
	}

	public int getBlockSize() {
		return (int) Math.sqrt(size);
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

	public int[] getAvailableSizes() {
		return AVAILABLE_SIZES;
	}

}
