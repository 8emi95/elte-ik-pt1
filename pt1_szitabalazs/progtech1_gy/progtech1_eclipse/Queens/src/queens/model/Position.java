package queens.model;

import java.util.Objects;

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
    public int hashCode() {
        return 31 * (31 + x) + y; //return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position other = (Position) obj;
            return other.x == x && other.y == y; 
        }
        return false;
    }
}
