package hu.elte.prt.landmine.model.domain;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Position) {
            return x == ((Position) other).getX() && y == ((Position) other).getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x * 31 + y * 7;
    }
}
