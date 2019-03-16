package hu.elte.progtech.mines.model;

import java.util.List;
import java.util.ArrayList;

public class MinesEngine {
	private final int SIZE = 6;

	private List<Position> path;
	private boolean isPaused;
	private Position player;

	public void startGame() {
		path = new ArrayList<>();
		isPaused = false;
		player = new Position(0, 0);
	}

	public int getSize() {
		return SIZE;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public boolean isInPath(int row, int column) {
		return path.contains(new Position(row, column));
	}

	public void moveTo(int row, int column) {
		if((Math.abs(player.getRow() - row) <= 1 && player.getColumn() == column) 
			|| (Math.abs(player.getColumn() - column) <= 1  && player.getRow() == row)) {
			path.add(player);
			player = new Position(row, column);
		}
	}

	public boolean isPlayersPosition(int row, int column) {
		return player.equals(new Position(row, column));
	}
}
