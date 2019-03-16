package game.engine;

import static game.engine.Player.ONE;
import static game.engine.Player.TWO;

public class GameBoard {

	private Figure[][] board;
	private Figure winnerFigure;

	public GameBoard(int size) {
		winnerFigure = null;
		board = new Figure[size][size];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = new Figure(ONE, new Position(i, j), size - 1);
				board[size - 1 - i][j] = new Figure(TWO, new Position(size - 1 - i, j), 0);
			}
		}
	}

	public Figure getFigure(int row, int column) {
		return board[row][column];
	}

	public void moveFigure(Figure selectedFigure, int row, int column) {
		board[selectedFigure.getPosition().getRow()][selectedFigure.getPosition().getColumn()] = null;
		selectedFigure.setPosition(new Position(row, column));
		board[row][column] = selectedFigure;
		if (selectedFigure.inWinningRow()){
			winnerFigure = selectedFigure;
		}
	}

	public boolean gameWon() {
		return null != winnerFigure;
	}

	public Figure getWinnerFigure() {
		return winnerFigure;
	}

}
