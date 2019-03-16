package game.engine;

import static game.engine.Player.NOBODY;
import static game.engine.Player.ONE;
import static game.engine.Player.TWO;
import static java.time.Duration.ZERO;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameEngine {

	private int size;

	private GameBoard board;
	private Player actualPlayer;
	private Figure actualFigure;
	private boolean isPaused;

	private Instant startTime;
	private Timer pauseTimer;

	public GameEngine() {
		actualPlayer = NOBODY;
	}

	public int getSize() {
		return size;
	}

	public void startNewGame(int size) {
		this.size = size;
		initalizeBoard(size);
		actualPlayer = new Random().nextBoolean() ? ONE : TWO;
		actualFigure = null;
		isPaused = false;
		startTime = Instant.now();
		if (pauseTimer != null) {
			pauseTimer.cancel();
			pauseTimer.purge();
		}
	}

	private void initalizeBoard(int size) {
		board = new GameBoard(size);
	}

	public Player getPlayer(int row, int column) {
		return null == board.getFigure(row, column) ? NOBODY : board.getFigure(row, column).getOwner();
	}

	public void actionInField(int row, int column) {
		if (NOBODY != actualPlayer) {
			Figure selectedFigure = board.getFigure(row, column);
			if (null != selectedFigure) {
				if (actualPlayer == selectedFigure.getOwner()) {
					actualFigure = selectedFigure;
				} else if (null != actualFigure && Math.abs(selectedFigure.getPosition().getColumn() - actualFigure.getPosition().getColumn()) == 1) {
					moveFigure(actualFigure, row, column);
				}
			} else {
				if (null != actualFigure) {
					moveFigure(actualFigure, row, column);
				}
			}
		}

	}

	private void moveFigure(Figure selectedFigure, int row, int column) {
		if (!isPaused && selectedFigure.canMoveTo(row, column)) {
			board.moveFigure(selectedFigure, row, column);
			actualFigure = null;
			if (selectedFigure.inWinningRow()) {
				stopTheTimer();
				actualPlayer = NOBODY;
			} else {
				actualPlayer = actualPlayer.getOpponent();
			}
		}
	}

	public boolean gameWon() {
		return board.gameWon();
	}

	public Player getWinner() {
		return board.getWinnerFigure().getOwner();
	}

	public void togglePause() {
		if (!isPaused) {
			stopTheTimer();

			isPaused = true;
		} else {
			pauseTimer.cancel();
			isPaused = false;
		}
	}

	private void stopTheTimer() {
		pauseTimer = new Timer();
		pauseTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				startTime = startTime.plus(1, SECONDS);
			}
		}, 0, 1000);
	}

	public boolean isPaused() {
		return isPaused;
	}

	public Duration getPlayDuration() {
		return null == startTime ? ZERO : Duration.between(startTime, Instant.now());
	}

	public Player getActualPlayer() {
		return actualPlayer;
	}
}
