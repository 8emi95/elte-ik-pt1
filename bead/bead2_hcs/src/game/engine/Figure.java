package game.engine;

public class Figure {

	private final Player owner;
	private Position position;
	private int winningRow;

	public Figure(Player owner, Position position, int winningRow) {
		this.owner = owner;
		this.setPosition(position);
		this.winningRow = winningRow;
	}

	public int getWinningRow() {
		return winningRow;
	}

	public Player getOwner() {
		return owner;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean canMoveTo(int row, int column) {
		return movingTowardsWinningLine(row) && movesOneRow(row) && movesOneColumnOrStaysInSame(column);
	}

	private boolean movesOneRow(int row) {
		return Math.abs(position.getRow() - row) == 1;
	}

	private boolean movesOneColumnOrStaysInSame(int column) {
		return Math.abs(position.getColumn() - column) <= 1;
	}

	private boolean movingTowardsWinningLine(int row) {
		return Math.abs(winningRow - row) < Math.abs(winningRow - position.getRow());
	}
	
	public boolean inWinningRow(){
		return position.getRow() == winningRow;
	}
}
