package hu.valdar.progtech.zh.logic;

public final class GameLogic {

    private final int[][] gameTable;
    private int rounds;
    private int scores;
    private int steps1;
    private int steps2;
    

    
    public int getScores() {
        return scores;
    }
    
    public int getSteps1() {
        return steps1;
    }
    
    public int getSteps2() {
        return steps2;
    }

    public GameLogic() {
        this.gameTable = new int[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];
        createNewGame();
    }

    public void createNewGame() {
        for (int i = 0; i < GameConstants.BOARD_SIZE; ++i) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; ++j) {
                gameTable[i][j] = 0;
            }
        }
        rounds = 0;
        steps1 = 0;
        steps2 = 0;
        scores = 0;
    }

    public void modifyValuesFromSource(int x, int y) {
            modifyValue(x, y);
            modifyNextToSource(x, y);
            modifyAboveBelowSource(x, y);
        ++rounds;
//        if (rounds % 2 == 0)  {
//            steps2++;
//        } else {
//            steps1++;
//        }
    }
    
    private void modifyNextToSource(int x, int y){
        if ((x - 1) >= 0) {
            modifyValue(x - 1, y);
        }
        
        if ((x + 1) < GameConstants.BOARD_SIZE) {
            modifyValue(x + 1, y);
        }
    }

    private void modifyAboveBelowSource(int x, int y){
        if ((y - 1) >= 0) {
            modifyValue(x, y - 1);
        }

        if ((y + 1) < GameConstants.BOARD_SIZE) {
            modifyValue(x, y + 1);
        }

    }

    private void modifyValue(int x, int y) {
        if (!isScore(x, y)) {
            gameTable[x][y]++;
            if (isScore(x, y)) {
                scores++;
                increaseScore();
            }
        }
    }
    private void increaseScore() {
        if (rounds % 2 == 0)  {
            steps1++;
        } else {
            steps2++;
        }
    }
    
    public int getFieldValue(int x, int y){
        return gameTable[x][y];
    }
    
    public boolean isScore(int x, int y) {
        return gameTable[x][y] == 4;
    }

    // Az értékek csökkenés ellenörzése:
    public boolean isGameWon() {
        final int[] array = tableToArray();
        boolean allIsFour = true;
        int i = 0;
        while (i < array.length && allIsFour) {
            allIsFour = array[i] == 4;
            ++i;
        }
        return allIsFour;
    }
    
    public String getWinner() {
        if (steps1 > steps2) {
            return "Player1";
        } else {
            return "Player2" ;
        }
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
}
