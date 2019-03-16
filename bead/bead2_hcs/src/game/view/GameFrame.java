package game.view;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import game.engine.GameEngine;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final String NEW_GAME_TITLE = "New game";
	private static final String NEW_GAME_TEXT = "Select a new game table size";
	private static final String GAME_TITLE = "Another /* minf_ing */ game XD";
	private static final int DEFAULT_BOARD_SIZE = 10;

	private static Integer[] gameSizes = new Integer[] { 6, 8, 10 };
	private GameEngine engine;
	private GamePanel gamePanel;
	private InfoPanel infoPanel;

	public GameFrame(GameEngine engine) {
		super(GAME_TITLE);
		this.engine = engine;
		engine.startNewGame(DEFAULT_BOARD_SIZE);
		gamePanel = new GamePanel(engine, this);
		gamePanel.startNewGame();
		infoPanel = new InfoPanel(engine);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public void showFrame() {
		this.setLocation(50, 50);
		addMenu();
		getContentPane().add(infoPanel, NORTH);
		getContentPane().add(gamePanel, SOUTH);
		setVisible(true);
		pack();
	}

	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new GameMenu(engine, gamePanel, this);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	public void startNewGame() {
		final Object resultObject = JOptionPane.showInputDialog(rootPane, NEW_GAME_TEXT, NEW_GAME_TITLE,
				QUESTION_MESSAGE, null, gameSizes, gameSizes[gameSizes.length - 1]);
		if (resultObject != null) {
			int size = ((int) resultObject);
			engine.startNewGame(size);
			gamePanel.startNewGame();
			pack();
		}
	}

}
