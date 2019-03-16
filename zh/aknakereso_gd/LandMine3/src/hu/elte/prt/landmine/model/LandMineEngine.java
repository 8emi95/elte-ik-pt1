package hu.elte.prt.landmine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.elte.prt.landmine.model.domain.Field;
import hu.elte.prt.landmine.model.domain.Position;

public class LandMineEngine {
    private static final int SIZE = 6;

    private LandMineListener listener;
    private Field[][] fields;
    private Random generator = new Random(System.currentTimeMillis());
    private List<Position> stepsFrom;

    public void startNewGame() {
        stepsFrom = new ArrayList<>();
        List<Position> mines = generateMines();
        fields = new Field[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                fields[i][j] = new Field(isPlayerBornHere(i, j), isMineHere(mines, i, j));
            }
        }
        stepsFrom.add(getPlayerPosition());
        listener.updateFields();
    }

    private boolean isPlayerBornHere(int i, int j) {
        return 0 == i && 0 == j;
    }

    private List<Position> generateMines() {
        int mineCount = get1Or2();
        List<Position> mines = new ArrayList<>(mineCount);
        for (int i = 0; i < mineCount; ++i) {
            plantMine(mines);
        }
        return mines;
    }

    private int get1Or2() {
        return generator.nextInt(2) + 1;
    }

    private void plantMine(List<Position> mines) {
        boolean added = false;
        while (!added) {
            Position candidate = new Position(generator.nextInt(SIZE), generator.nextInt(SIZE));
            if (legalToPlantMine(mines, candidate)) {
                mines.add(candidate);
                added = true;
            }
        }
    }

    private boolean legalToPlantMine(List<Position> mines, Position candidate) {
        return !isPlayerBornHere(candidate.getX(), candidate.getY())
            && !isEndPosition(candidate.getX(), candidate.getY()) && !mines.contains(candidate);
    }

    private boolean isEndPosition(int i, int j) {
        return SIZE - 1 == i && SIZE - 1 == j;
    }

    private boolean isMineHere(List<Position> mines, int i, int j) {
        return mines.contains(new Position(i, j));
    }

    public void step(int i, int j) {
        Position playerPosition = getPlayerPosition();
        if (isNextToPlayer(playerPosition, i, j)) {
            fields[playerPosition.getX()][playerPosition.getY()].leave();
            fields[i][j].visit();
            stepsFrom.add(getPlayerPosition());
            listener.updateFields();
            checkEndGame(i, j);
        }
    }

    private Position getPlayerPosition() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (fields[i][j].isPlayerHere()) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private boolean isNextToPlayer(Position playerPosition, int i, int j) {
        return notTheSame(playerPosition, i, j) && near(playerPosition, i, j);
    }

    private boolean notTheSame(Position playerPosition, int i, int j) {
        return playerPosition.getX() != i || playerPosition.getY() != j;
    }

    private boolean near(Position playerPosition, int i, int j) {
        return 1 >= Math.abs(playerPosition.getX() - i) && 1 >= Math.abs(playerPosition.getY() - j);
    }

    private void checkEndGame(int i, int j) {
        if (hasMine(i, j)) {
            listener.end(false);
            startNewGame();
        } else if (isEndPosition(i, j)) {
            listener.end(true);
            startNewGame();
        }
    }

    public void setListener(LandMineListener listener) {
        this.listener = listener;
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isPlayerHere(int i, int j) {
        return fields[i][j].isPlayerHere();
    }

    public boolean isVisited(int i, int j) {
        return fields[i][j].isVisited();
    }

    public boolean hasMine(int i, int j) {
        return fields[i][j].hasMine();
    }

    public void undo() {
        if (moved()) {
            leaveLastPosition();
            revisitPenultimatePosition();
            listener.updateFields();
        }
    }

    private boolean moved() {
        return stepsFrom.size() > 1;
    }

    private void leaveLastPosition() {
        Position lastPos = getLastPosition();
        stepsFrom.remove(stepsFrom.size() - 1);
        fields[lastPos.getX()][lastPos.getY()].leave();
        forgetIsVisitedIfIsNotVisitedBefore(lastPos);
    }

    private Position getLastPosition() {
        return stepsFrom.get(stepsFrom.size() - 1);
    }

    private void forgetIsVisitedIfIsNotVisitedBefore(Position removedPos) {
        if (!stepsFrom.contains(removedPos)) {
            fields[removedPos.getX()][removedPos.getY()].forgetIsVisited();
        }
    }

    private void revisitPenultimatePosition() {
        Position newlyLastPos = getLastPosition();
        fields[newlyLastPos.getX()][newlyLastPos.getY()].visit();
    }
}
