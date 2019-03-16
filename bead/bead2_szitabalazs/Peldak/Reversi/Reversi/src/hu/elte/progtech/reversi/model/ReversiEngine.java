package hu.elte.progtech.reversi.model;

import static hu.elte.progtech.reversi.model.ReversiColor.BLACK;
import static hu.elte.progtech.reversi.model.ReversiColor.EMPTY;
import static hu.elte.progtech.reversi.model.ReversiColor.WHITE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

public class ReversiEngine {

	private static final int SIZE = 8;
	private static final int TIME_TO_PUT = 20;
	private static final double AWARD_WIN = 1;
	private static final double AWARD_DRAW = 0.5;

	private ReversiView view;
	private ReversiColor[][] board;
	private ReversiColor playerToStep;

	private Timer timer;
	private int elapsedTime;
	private int timeToPut;

	private Map<Position, List<Position>> fieldsToFlip;

	private Map<ReversiColor, Integer> scores;
	private Map<ReversiColor, Double> wins;

	public void setView(ReversiView view) {
		this.view = view;
	}

	public int getSize() {
		return SIZE;
	}

	public ReversiEngine() {
		wins = new HashMap<>();
		wins.put(BLACK, 0.0);
		wins.put(WHITE, 0.0);
		board = new ReversiColor[SIZE][SIZE];
		scores = new HashMap<>();
		fieldsToFlip = new HashMap<>();
	}

	public void startNewGame() {
		initializeBoardAndScores();
		initializePlayerToStep();
		initializeTimeAndTimer();
	}

	private void initializeBoardAndScores() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				initializeField(i, j);
			}
		}
		scores.put(BLACK, 2);
		scores.put(WHITE, 2);
	}

	private void initializeField(int row, int column) {
		if (initializeAsBlack(row, column)) {
			board[row][column] = BLACK;
		} else if (initializeAsWhite(row, column)) {
			board[row][column] = WHITE;
		} else {
			board[row][column] = EMPTY;
		}
		view.update(row, column);
	}

	private boolean initializeAsBlack(int row, int column) {
		return (row == 3 && column == 4) || (row == 4 && column == 3);
	}

	private boolean initializeAsWhite(int row, int column) {
		return (row == 3 && column == 3) || (row == 4 && column == 4);
	}

	private void initializePlayerToStep() {
		playerToStep = BLACK;
		view.nextTurn(playerToStep);
		getFieldsToFlip();
	}

	private void getFieldsToFlip() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				Position position = new Position(i, j);
				fieldsToFlip.put(position, getFieldsToFlip(position));
			}
		}
	}

	private List<Position> getFieldsToFlip(Position position) {
		List<Position> fieldsToFlipByPosition = new ArrayList<>();
		if (EMPTY.equals(board[position.getRow()][position.getColumn()])) {
			fieldsToFlipByPosition.addAll(getFieldsToFlipToNorth(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToSouth(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToWest(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToEast(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToNorthWest(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToSouthWest(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToNorthEast(position));
			fieldsToFlipByPosition.addAll(getFieldsToFlipToSouthEast(position));
		}
		return fieldsToFlipByPosition;
	}

	private List<Position> getFieldsToFlipToNorth(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() - 1, p.getColumn()));
	}

	private List<Position> getFieldsToFlipToSouth(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() + 1, p.getColumn()));
	}

	private List<Position> getFieldsToFlipToWest(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow(), p.getColumn() - 1));
	}

	private List<Position> getFieldsToFlipToEast(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow(), p.getColumn() + 1));
	}

	private List<Position> getFieldsToFlipToNorthWest(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() - 1, p.getColumn() - 1));
	}

	private List<Position> getFieldsToFlipToSouthWest(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() + 1, p.getColumn() - 1));
	}

	private List<Position> getFieldsToFlipToNorthEast(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() - 1, p.getColumn() + 1));
	}

	private List<Position> getFieldsToFlipToSouthEast(Position position) {
		return getFieldsToFlip(position, p -> new Position(p.getRow() + 1, p.getColumn() + 1));
	}

	private List<Position> getFieldsToFlip(Position newStone, Function<Position, Position> modifier) {
		List<Position> fieldsToFlip = new ArrayList<>();
		Position enemy = modifier.apply(newStone);
		while (inBoard(enemy) && playerToStep.enemy().equals(board[enemy.getRow()][enemy.getColumn()])) {
			fieldsToFlip.add(enemy);
			enemy = modifier.apply(enemy);
		}
		if (inBoard(enemy) && playerToStep.equals(board[enemy.getRow()][enemy.getColumn()])) {
			return fieldsToFlip;
		} else {
			return new ArrayList<>();
		}
	}

	private boolean inBoard(Position field) {
		return field.getRow() >= 0 && field.getRow() < SIZE && field.getColumn() >= 0 && field.getColumn() < SIZE;
	}

	private void initializeTimeAndTimer() {
		elapsedTime = 0;
		timeToPut = TIME_TO_PUT;
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				view.updateTime(elapsedTime++);
				view.updateTimeToPut(timeToPut--);
				if (timeToPut < 0) {
					endGame(playerToStep.enemy());
				}
			}
		}, 0, 1000);
	}

	public ReversiColor getField(int row, int column) {
		return board[row][column];
	}

	public void put(int row, int column) {
		Position position = new Position(row, column);
		if (canPutHere(position)) {
			updateField(row, column);
			flipFields(position);
			scores.put(playerToStep, scores.get(playerToStep) + fieldsToFlip.get(position).size() + 1);
			scores.put(playerToStep.enemy(), scores.get(playerToStep.enemy()) - fieldsToFlip.get(position).size());
			timeToPut = TIME_TO_PUT;
			changePlayer();
		} else {
			view.cantPutHere();
		}
	}

	private boolean canPutHere(Position position) {
		return !fieldsToFlip.get(position).isEmpty();
	}

	private void updateField(int row, int column) {
		board[row][column] = playerToStep;
		view.update(row, column);
	}

	private void flipFields(Position position) {
		for (Position enemy : fieldsToFlip.get(position)) {
			updateField(enemy.getRow(), enemy.getColumn());
		}
	}

	private void changePlayer() {
		playerToStep = playerToStep.enemy();
		getFieldsToFlip();
		if (!canStep()) {
			playerToStep = playerToStep.enemy();
			getFieldsToFlip();
			if (!canStep()) {
				ReversiColor winner = hasMoreFields();
				endGame(winner);
			} else {
				view.samePlayerNextTurn(playerToStep);
			}
		} else {
			view.nextTurn(playerToStep);
		}
	}

	private boolean canStep() {
		for (List<Position> wouldFlip : fieldsToFlip.values()) {
			if (!wouldFlip.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	private ReversiColor hasMoreFields() {
		if (scores.get(BLACK) > scores.get(WHITE)) {
			return BLACK;
		} else if (scores.get(WHITE) > scores.get(BLACK)) {
			return WHITE;
		} else {
			return EMPTY;
		}
	}

	private void endGame(ReversiColor winner) {
		giveAwards(winner);
		timer.cancel();
		view.endGame(winner);
	}

	private void giveAwards(ReversiColor winner) {
		if (BLACK.equals(winner)) {
			wins.put(BLACK, wins.get(BLACK) + AWARD_WIN);
		} else if (WHITE.equals(winner)) {
			wins.put(WHITE, wins.get(WHITE) + AWARD_WIN);
		} else {
			wins.put(WHITE, wins.get(WHITE) + AWARD_DRAW);
			wins.put(WHITE, wins.get(WHITE) + AWARD_DRAW);
		}
	}

	public int getBlackFields() {
		return scores.get(BLACK);
	}

	public int getWhiteFields() {
		return scores.get(WHITE);
	}

	public double getBlackWins() {
		return wins.get(BLACK);
	}

	public double getWhiteWins() {
		return wins.get(WHITE);
	}

	public int getSecondsRemaining() {
		return timeToPut;
	}

}
