package hu.elte.prt.eightqueens.model;

public class Position {
    private int row;

    private int column;

    public Position(int row, int column) {
	this.row = row;
	this.column = column;
    }

    public int getRow() {
	return row;
    }

    public int getColumn() {
	return column;
    }

    @Override
    public boolean equals(Object o) {
	if (o instanceof Position) {
	    Position p = (Position) o;
	    return row == p.getRow() && column == p.getColumn();
	}
	return false;
    }

    @Override
    public int hashCode() {
	return row * 11 + column * 7;
    }
}
