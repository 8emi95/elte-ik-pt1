package hu.elte.progtech.queens.model;

import java.util.Stack;

public class QueensEngine {

	private static final int SIZE = 8;
	private Stack<Position> queens;

	public void startNewGame() {
		queens = new Stack<>();
	}

	public int getSize() {
		return SIZE;
	}

	public void put(int row, int column) {
		if (queens.size() == column) {
			queens.add(new Position(row, column));
		}
	}

	public boolean isQueen(int row, int column) {
		return queens.contains(new Position(row, column));
	}
}
