package hu.elte.progtech.dama.model;

import static hu.elte.progtech.dama.model.Field.EMPTY;
import static hu.elte.progtech.dama.model.Field.RED;
import static hu.elte.progtech.dama.model.Field.WHITE;

public class CheckersEngine {

	public static final int SIZE = 8;

	private Field fields[][];
	private Field playerToStep;
	private Integer selectedRow;
	private Integer selectedColumn;

	public CheckersEngine() {
		playerToStep = RED;
		fields = new Field[SIZE][SIZE];
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (i < 3 && (i + j) % 2 == 1) {
					fields[i][j] = RED;
				} else if (i >= SIZE - 3 && (i + j) % 2 == 1) {
					fields[i][j] = WHITE;
				} else {
					fields[i][j] = EMPTY;
				}
			}
		}
	}

	public Field getValue(int i, int j) {
		return fields[i][j];
	}

	public void step(int i, int j) {
		if (selectedRow == null && playerToStep == fields[i][j]) {
			if (!canHit() || canHit(i, j)) {
				selectedRow = i;
				selectedColumn = j;
			}
		} else if (selectedRow != null) {
			if (isNextLine(i) && Math.abs(j - selectedColumn) == 1 && isAccessible(i, j) && !canHit()) {
				stepTo(i, j);
			} else if (isNextOfNextLine(i) && Math.abs(j - selectedColumn) == 2 && isAccessible(i, j)) {
				if (isEnemy((i + selectedRow) / 2, (j + selectedColumn) / 2)) {
					hit(i, j);
				}
			}
		}
	}

	private void hit(int i, int j) {
		fields[i][j] = playerToStep;
		fields[selectedRow][selectedColumn] = EMPTY;
		fields[(i + selectedRow) / 2][(j + selectedColumn) / 2] = EMPTY;
		selectedRow = null;
		selectedColumn = null;
		if (!canHit()) {
			switchPlayerToStep();
		}
	}

	private void stepTo(int i, int j) {
		fields[i][j] = playerToStep;
		fields[selectedRow][selectedColumn] = EMPTY;
		selectedRow = null;
		selectedColumn = null;
		switchPlayerToStep();
	}

	private boolean isNextOfNextLine(int i) {
		if (playerToStep == RED) {
			return i == selectedRow + 2;
		} else {
			return i == selectedRow - 2;
		}
	}

	private boolean canHit() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (fields[i][j] == playerToStep && canHit(i, j)) {
					return true; //bugos
				}
			}
		}
		return false;
	}

	private boolean canHit(int i, int j) {
		int nextLine = getNextLine(i);
		return isEnemy(nextLine, j - 1) || isEnemy(nextLine, j + 1);
	}

	private boolean isEnemy(int row, int column) {
		if (row >= SIZE || row < 0 || column >= SIZE || column < 0) {
			return false;
		} else {
			return playerToStep == RED ? fields[row][column] == Field.WHITE : fields[row][column] == Field.RED;
		}
	}

	private int getNextLine(int i) {
		return playerToStep == RED ? i + 1 : i - 1;
	}

	private boolean isAccessible(int i, int j) {
		return fields[i][j] == EMPTY;
	}

	private boolean isNextLine(int i) {
		if (playerToStep == RED) {
			return i == selectedRow + 1;
		} else {
			return i == selectedRow - 1;
		}
	}

	private void switchPlayerToStep() {
		playerToStep = playerToStep == RED ? WHITE : RED;
	}

}
