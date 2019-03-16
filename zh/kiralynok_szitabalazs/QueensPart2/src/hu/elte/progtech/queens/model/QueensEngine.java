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

	public boolean put(int row, int column) {
		if (queens.size() == column && !isChecked(row, column)) {
			queens.add(new Position(row, column));
			return true;
		}
		return false;
	}

	private boolean isChecked(int row, int column) {
		for (Position queen : queens) {
			if (sameRow(row, queen) || sameColumn(column, queen) || sameDiagonal(row, column, queen)) {
				return true;
			}
		}
		return false;
	}

	private boolean sameRow(int row, Position queen) {
		return queen.getRow() == row;
	}

	private boolean sameColumn(int column, Position queen) {
		return queen.getColumn() == column;
	}

	private boolean sameDiagonal(int row, int column, Position queen) {
		return Math.abs(queen.getRow() - row) == Math.abs(queen.getColumn() - column);
	}

	public boolean isQueen(int row, int column) {
		return queens.contains(new Position(row, column));
	}

	public boolean isWon() {
		return SIZE == queens.size();
	}
}
