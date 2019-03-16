package model;

public class ChessBoard {
	public static final int SIZE = 8;
	private int x = 0;
	private int y = 0;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void move(int x, int y) throws InvalidMoveException {
		if (isValidStep(x, y)) {
			this.x = x;
			this.y = y;
		}
		else {
			throw new InvalidMoveException();
		}
	}

	private boolean isValidStep(int x, int y) {
		if (x >= SIZE || y >= SIZE) return false;
		if (Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1 ||
				Math.abs(this.y - y) == 2 && Math.abs(this.x - x) == 1) {
			return true;
		}
		return false;
	}
	
	public void reset() {
		x = y = 0;
	}
	
}
