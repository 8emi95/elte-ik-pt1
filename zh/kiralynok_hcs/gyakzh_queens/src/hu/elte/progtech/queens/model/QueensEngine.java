package hu.elte.progtech.queens.model;

import java.util.Stack;

public class QueensEngine {

	private static final int SIZE = 8;
	private Stack<Position> queens;
	private boolean isPaused;

	public void startGame() {
		queens = new Stack<>();
		isPaused = false;
	}

	public int getSize() {
		return SIZE;
	}

	public boolean putQueen(int row, int column) {
		if (isAvailableToPut(row, column)) {
			queens.add(new Position(row, column));
			return true;
		}
		return false;
	}

	public boolean isAvailableToPut(int row, int column) {
		return queens.size() == column && !isChecked(row, column);
	}

	private boolean isChecked(int row, int column) {
		for (Position queen:queens) 
			if(sameRow(row, queen) || sameColumn(column, queen) || sameDiagonal(row, column, queen)){
				return true;
			}
			return false;
	}

	private boolean sameDiagonal(int row, int column, Position queen) {
		return Math.abs(queen.getRow() - row) == Math.abs(queen.getColumn() - column);
	}

	private boolean sameColumn(int column, Position queen) {
		return column == queen.getColumn();
	}

	private boolean sameRow(int row, Position queen) {
		return row == queen.getRow();
	}

	public boolean isQueen(int row, int column) {
		return queens.contains(new Position(row, column));
	}

	public boolean isWon() {
		return queens.size() == SIZE;
	}

	public void undo() {
		if (queens.size() > 0) {
			queens.pop();
		}
	}

	public void togglePause() {
		isPaused = !isPaused;
	}

	public boolean isPaused() {
		return isPaused;
	}

}