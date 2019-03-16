package view;

import model.ChessBoard;

public class Main {
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		new ChessFrame(chessBoard).setVisible(true);
	}
}
