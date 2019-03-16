package hu.elte.progtech.mines.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class MinesEngine {
	private final int SIZE = 6;

	private List<Position> path;
	private List<Position> mines;
	private boolean isPaused;
	private Position player;

	private Random random;

	private Position finish;

	public void startGame() {
		path = new ArrayList<>();
		isPaused = false;
		player = new Position(0, 0);
		mines = generateMines();
	}

	private List<Position> generateMines() {
		List<Position> mines = new ArrayList<>();
		random = new Random(); 
		for (int i = 0; i < random.nextInt(1) + 1 ; i++) {
			mines.add(generateMine());
		}
		return mines;
	}

	private Position generateMine() {
		Position mine = new Position(random.nextInt(6), random.nextInt(6));
		if (mine.equals(player) || mine.equals(finish))
			return generateMine();
		return mine;
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

	public boolean moveTo(int row, int column) {
		if((Math.abs(player.getRow() - row) <= 1 && player.getColumn() == column) 
			|| (Math.abs(player.getColumn() - column) <= 1  && player.getRow() == row)) {
			path.add(player);
			player = new Position(row, column);
			return true;
		}
		return false;
	}

	public boolean isPlayersPosition(int row, int column) {
		return player.equals(new Position(row, column));
	}

	public boolean isBlownUp() {
		return mines.contains(player);
	}

	public boolean isWon() {
		finish = new Position(SIZE-1, SIZE-1);
		return player.equals(finish);
	}

	public void togglePause() {
		isPaused = !isPaused;
	}
}
