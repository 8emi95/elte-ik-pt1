package game.view;

public class PlayerOneIcon extends PlayerIcon {

	private static final long serialVersionUID = 727159637121305103L;

	public PlayerOneIcon(int fieldWidth, int fieldHeight) {
		super("white.png", fieldWidth, fieldHeight);
	}

	@Override
	public String getName() {
		return "White";
	}
}
