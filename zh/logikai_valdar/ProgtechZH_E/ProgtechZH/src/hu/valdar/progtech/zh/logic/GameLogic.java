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
        modifyAllInDiagonalFromSource(x, y);
        modifyAllInColumnLowerSource(x, y);
        ++steps;
    }

    /*
     * Ebben az esetben az indexek különbségei megegyeznek az adott diagonlisban.
     *
     *  Példa:
     * [0,0] [0,1] [0,2]
     * [1,0] [1,1] [1,2]
     * [2,0] [2,1] [2,2]
     *
     *  0 -1 -2
     *  1  0 -1
     *  2  1  0
     */
    private void modifyAllInDiagonalFromSource(int x, int y){
        final int sub = x - y;
        for(int i = 0; i < GameConstants.BOARD_SIZE; ++i){
            for(int j = 0; j < GameConstants.BOARD_SIZE; ++j){
                if(sub == i - j){
                    modifyValue(i, j);
                }
            }
        }
    }

    private void modifyAllInColumnLowerSource(int x, int y){
        for(int i = 0; i < GameConstants.BOARD_SIZE; ++i){
            if(i > x) {
                modifyValue(i, y);
            }
        }
    }

    private void modifyValue(int x, int y) {
        gameTable[x][y] = gameTable[x][y] - 1;
    }

    public int getFieldValue(int x, int y){
        return gameTable[x][y];
    }

    // Az értékek növekedésének ellenörzése:
    public boolean isGameWon() {
        final int[] array = tableToArray();
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
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
