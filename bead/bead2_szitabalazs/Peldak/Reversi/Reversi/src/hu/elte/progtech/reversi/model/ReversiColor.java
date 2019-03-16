package hu.elte.progtech.reversi.model;

public enum ReversiColor {
	EMPTY, BLACK, WHITE;

	@Override
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
	}

	public ReversiColor enemy() {
		return BLACK.equals(this) ? WHITE : BLACK;
	}

}
