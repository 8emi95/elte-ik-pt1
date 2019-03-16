package game.view;

public class PlayerTwoIcon extends PlayerIcon {

	private static final long serialVersionUID = 1641275335204309236L;

	public PlayerTwoIcon(int fieldWidth, int fieldHeight) {
		super("black.png", fieldWidth, fieldHeight);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Black";
	}
}
