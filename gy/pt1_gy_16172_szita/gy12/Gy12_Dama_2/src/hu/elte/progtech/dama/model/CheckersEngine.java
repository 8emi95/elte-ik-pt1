package hu.elte.progtech.dama.model;

import static hu.elte.progtech.dama.model.Field.EMPTY;
import static hu.elte.progtech.dama.model.Field.RED;
import static hu.elte.progtech.dama.model.Field.WHITE;

public class CheckersEngine {

	public static final int SIZE = 8;

	private Field fields[][];

	public CheckersEngine() {
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

}
