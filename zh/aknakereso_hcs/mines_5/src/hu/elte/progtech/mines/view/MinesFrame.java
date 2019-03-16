package hu.elte.progtech.mines.view;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import hu.elte.progtech.mines.model.MinesEngine;

public class MinesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String FRAME_TITLE = "Mines";
	private MinesEngine engine;

	private InfoPanel infoPanel;
	private GamePanel gamePanel;

	public MinesFrame(MinesEngine engine) {
		this.engine = engine;
		engine.startGame();

		infoPanel = new InfoPanel(engine);
		gamePanel = new GamePanel(engine, infoPanel);

		getContentPane().add(infoPanel, NORTH);
		getContentPane().add(gamePanel, SOUTH);
	}

	public void showFrame() {
		setTitle(FRAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(150, 150);
		addMenu();

		setVisible(true);
		pack();
	}

	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new GameMenu(engine, gamePanel);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
}
