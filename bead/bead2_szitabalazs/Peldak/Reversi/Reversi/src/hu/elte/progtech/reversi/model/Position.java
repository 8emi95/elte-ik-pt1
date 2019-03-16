package hu.elte.progtech.reversi.model;

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
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position other = (Position) obj;
			return row == other.row && column == other.column;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * (31 + column) + row;
	}

}
