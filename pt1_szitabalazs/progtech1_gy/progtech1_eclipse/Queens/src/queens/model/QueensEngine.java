package queens.model;

import java.util.Stack;

public class QueensEngine {
    private static final int SIZE = 8;
    private Stack<Position> queens; // x,y koordinátákat tárolunk Positionben
    private boolean paused;

    public void startNewGame() {
        queens = new Stack<>();
        paused = false;
    }

    public int getSize() {
        return SIZE;
    }
    
    public boolean put(int row, int column) {
        if (column == queens.size() && !isChecked(row, column)) {
            queens.push(new Position(row, column)); // új pozícióelemet rak a listába
            return true;
        }
        return false;
    }

    public boolean isFree(int row, int column) {
        return column == queens.size() && !isChecked(row, column);
    }

    private boolean isChecked(int row, int column) {
        for (Position position : queens) {
             if (sameRow(position, row) || sameColumn(position, column) || sameDiagonal(position, row, column)) {
                return true;
            }
        }
        return false;
    }

    private boolean sameRow(Position position, int row) {
        return position.getX() == row;
    }

    private boolean sameColumn(Position position, int column) {
        return position.getY() == column;
    }

    private boolean sameDiagonal(Position position, int row, int column) {
        return Math.abs(position.getX() - row) == Math.abs(position.getY()- column);
    }

    public boolean isQueen(int row, int column) {
        return queens.contains(new Position(row, column));
    }
    
    public boolean hasWon() {
        return queens.size() == SIZE;
    }

    public void undo() {
        if (!queens.empty()) {
            queens.pop();
        }
    }
    
    public void togglePause() {
        paused = !paused;
    }

    public boolean isPaused() {
        return paused;
    }
}
