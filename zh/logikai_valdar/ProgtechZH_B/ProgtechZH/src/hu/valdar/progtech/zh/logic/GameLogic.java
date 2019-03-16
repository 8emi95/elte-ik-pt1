package hu.valdar.progtech.zh.logic;

import java.util.Random;

public final class GameLogic {

    private final int[][] gameTable;
    private final Random random;

    private int steps;

    public GameLogic() {
        this.gameTable = new int[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];
        this.random = new Random();
        createNewGame();
    }

    public void createNewGame() {
        for (int i = 0; i < GameConstants.BOARD_SIZE; ++i) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; ++j) {
                gameTable[i][j] = random.nextInt(GameConstants.MAX_RANDOM_NUMBER);
            }
        }
        steps = 0;
    }

    public void modifyValuesFromSource(int x, int y) {
        modifyAllInRow(x);
        modifyAllInColumnExceptSource(x, y);
        ++steps;
    }

    private void modifyAllInRow(int x){
        for(int j = 0; j < GameConstants.BOARD_SIZE; ++j){
            modifyValue(x, j);
        }
    }

    private void modifyAllInColumnExceptSource(int x, int y){
        for(int i = 0; i < GameConstants.BOARD_SIZE; ++i){
            if(i == x){
                continue;
            }

            modifyValue(i, y);
        }
    }

    private void modifyValue(int x, int y) {
        gameTable[x][y] = gameTable[x][y] - 1;
    }

    public int getFieldValue(int x, int y){
        return gameTable[x][y];
    }

    // Az értékek csökkenés ellenörzése:
    public boolean isGameWon() {
        final int[] array = tableToArray();
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Sorfolytonos változat:
    private int[] tableToArray() {
        final int[] gameTableArray = new int[GameConstants.BOARD_SIZE * GameConstants.BOARD_SIZE];
        for (int i = 0; i < GameConstants.BOARD_SIZE; ++i) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; ++j) {
                gameTableArray[i * GameConstants.BOARD_SIZE + j] = gameTable[i][j];
            }
        }
        return gameTableArray;
    }

    public int getSteps() {
        return steps;
    }
}
