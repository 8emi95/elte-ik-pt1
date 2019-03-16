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
			selectedRow = i;
			selectedColumn = j;
		} else if (selectedRow != null && isAccessible(i, j)) {
			fields[i][j] = playerToStep;
			fields[selectedRow][selectedColumn] = EMPTY;
			selectedRow = null;
			selectedColumn = null;
			switchPlayerToStep();
		}
	}

	private boolean isAccessible(int i, int j) {
		return fields[i][j] == EMPTY && Math.abs(j - selectedColumn) == 1 && isNextLine(i);
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
