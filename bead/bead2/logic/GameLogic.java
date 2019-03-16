package bead2.logic;

import bead2.logic.Player;

public final class GameLogic {
    private int boardSize;
    private int[][] gameBoard;
    private Player actualPlayer;
    private int player1Scores;
    private int player2Scores;

    public GameLogic() {
        actualPlayer = Player.NOBODY;
    }

    public void createNewGame(int boardSize) {
        this.boardSize = boardSize;
        this.gameBoard = new int[boardSize][boardSize];
        setupGameBoard();
        actualPlayer = Player.ONE;
        player1Scores = 0;
        player2Scores = 0;
    }

    private void setupGameBoard() {
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                gameBoard[i][j] = 0;
            }
        }
    }

    public void modifyValuesFromSource(int x, int y) {
        modifyValue(x, y);
        modifyNextToSource(x, y);
        modifyAboveBelowSource(x, y);
        actualPlayer = actualPlayer.getOpponent();
    }

    private void modifyNextToSource(int x, int y){
        if ((x - 1) >= 0) {
            modifyValue(x - 1, y);
        }

        if ((x + 1) < boardSize) {
            modifyValue(x + 1, y);
        }
    }

    private void modifyAboveBelowSource(int x, int y){
        if ((y - 1) >= 0) {
            modifyValue(x, y - 1);
        }

        if ((y + 1) < boardSize) {
            modifyValue(x, y + 1);
        }
    }

    private void modifyValue(int x, int y) {
        if (!isScore(x, y)) {
            ++gameBoard[x][y];
            if (isScore(x, y)) {
                increaseScore();
            }
        }
    }

    private void increaseScore() {
        switch (actualPlayer) {
            case ONE:
                ++player1Scores;
                break;
            case TWO:
                ++player2Scores;
                break;
            default:
        }
    }

    public boolean isScore(int x, int y) {
        return gameBoard[x][y] == 4;
    }

    public boolean isGameWon() {
        final int[] array = gameBoardToArray();
        boolean allIsFour = true;
        int i = 0;
        while (i < array.length && allIsFour) {
            allIsFour = array[i] == 4;
            ++i;
        }
        return allIsFour;
    }

    public String getWinner() {
        return (player1Scores > player2Scores) ? Player.ONE.toString() : Player.TWO.toString();
    }

    private int[] gameBoardToArray() {
        final int[] gameTableArray = new int[boardSize * boardSize];
        for (int i = 0; i < boardSize; ++i) {
            for (int j = 0; j < boardSize; ++j) {
                gameTableArray[i * boardSize + j] = gameBoard[i][j];
            }
        }
        return gameTableArray;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getPlayer1Scores() {
        return player1Scores;
    }

    public int getPlayer2Scores() {
        return player2Scores;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public int getFieldValue(int x, int y){
        return gameBoard[x][y];
    }
}
