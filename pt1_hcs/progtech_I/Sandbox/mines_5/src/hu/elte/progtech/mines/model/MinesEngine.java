package hu.elte.progtech.mines.model;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MinesEngine {
	private static final int GAME_TIME_MINUTES = 1;

	private final int SIZE = 6;

	private List<Position> path;
	private List<Position> mines;
	private boolean isPaused;
	private Position player;

	private Random random;

	private Position finish;

	private Instant startTime;
	private Instant endTime;

	private Timer pauseTimer;

	public void startGame() {
		path = new ArrayList<>();
		isPaused = false;
		player = new Position(0, 0);
		mines = generateMines();
		startTime = Instant.now();
		endTime = startTime.plus(GAME_TIME_MINUTES, MINUTES);
		if (pauseTimer != null) {
			pauseTimer.cancel();
			pauseTimer.purge();
		}
		;
	}

	public Duration getPlayDuration() {
		return null == startTime ? Duration.ZERO : Duration.between(startTime, Instant.now());
	}

	public Duration getRemainingDuration() {
		return null == endTime ? Duration.ZERO : Duration.between(Instant.now(), endTime);
	}

	private List<Position> generateMines() {
		List<Position> mines = new ArrayList<>();
		random = new Random();
		for (int i = 0; i < random.nextInt(1) + 1; i++) {
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
		if (!timeIsUp() && !isBlownUp() && !isWon() && fieldIsAvailableToStepOn(row, column)) {
			path.add(player);
			player = new Position(row, column);
			return true;
		}
		return false;
	}

	private boolean fieldIsAvailableToStepOn(int row, int column) {
		return !player.equals(new Position(row, column)) && isNeighbourField(row, column);
	}

	private boolean isNeighbourField(int row, int column) {
		return Math.abs(player.getRow() - row) <= 1 && player.getColumn() == column
				|| Math.abs(player.getColumn() - column) <= 1 && player.getRow() == row;
	}

	public boolean isPlayerPosition(int row, int column) {
		return player.equals(new Position(row, column));
	}

	public boolean isBlownUp() {
		return mines.contains(player);
	}

	public boolean isWon() {
		finish = new Position(SIZE - 1, SIZE - 1);
		return player.equals(finish);
	}

	public void togglePause() {
		if (!isPaused) {
			pauseTimer = new Timer();
			pauseTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					startTime = startTime.plus(1, SECONDS);
					endTime = endTime.plus(1, SECONDS);
				}
			}, 0, 1000);

			isPaused = true;
		} else {
			pauseTimer.cancel();
			isPaused = false;
		}
	}

	public int getSteps() {
		return path.size();
	}

	public boolean timeIsUp() {
		return Instant.now().isAfter(endTime);
	}
}
