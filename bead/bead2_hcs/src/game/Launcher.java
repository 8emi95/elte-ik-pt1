package game;

import game.engine.GameEngine;
import game.view.GameFrame;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameEngine engine = new GameEngine();
		GameFrame frame = new GameFrame(engine);
		frame.showFrame();
	}

}
