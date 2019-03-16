package model;

import java.awt.Color;

public class KnightModel {
	private static final Color UNDISTURBED_FIELD = Color.WHITE;
	private static final Color KNIGHT_POSITION = Color.ORANGE;
	private static final Color DISTURBED_FIELD = Color.GRAY;

	private Color[][] gameTable;
	private int size;
	private int steps;
	private int knightX;
	private int knightY;

	public void initTable(int size) {
		this.size = size;
		initGameTable();
	}

	private void initGameTable() {
		gameTable = new Color[size][size];

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				gameTable[i][j] = UNDISTURBED_FIELD;
			}
		}

		initKnight();
	}

	private void initKnight() {
		knightX = 0;
		knightY = 0;
		gameTable[knightX][knightY] = KNIGHT_POSITION;
	}

	public void initSteps() {
		steps = 0;
	}

	public void step(int i, int j) {
		if (UNDISTURBED_FIELD.equals(gameTable[i][j]) && isL(i, j)) {
			++steps;
			gameTable[knightX][knightY] = DISTURBED_FIELD;
			stepKnight(i, j);
		}
	}

	private void stepKnight(int i, int j) {
		knightX = i;
		knightY = j;
		gameTable[i][j] = KNIGHT_POSITION;
	}

	private boolean isL(int i, int j) {
		return Math.abs(i - knightX) == 2 && Math.abs(j - knightY) == 1
				|| Math.abs(i - knightX) == 1 && Math.abs(j - knightY) == 2;
	}

	public boolean isFinished() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (isUndisturbed(i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isUndisturbed(int i, int j) {
		return !DISTURBED_FIELD.equals(gameTable[i][j]) && !(knightX == i && knightY == j);
	}

	public int getSteps() {
		return steps;
	}

	public int getKnightX() {
		return knightX;
	}

	public int getKnightY() {
		return knightY;
	}

	public int getSize() {
		return size;
	}

	public Color getColor(int i, int j) {
		return gameTable[i][j];
	}

	public Color getDisturbedColor() {
		return DISTURBED_FIELD;
	}
}
