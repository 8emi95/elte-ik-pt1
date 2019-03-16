package game.view;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import game.engine.GameEngine;


public class GameMenu extends JMenu {
	
	private static final long serialVersionUID = 1036633302434967212L;

	private static final String NEW_GAME_LABEL = "New game";
	private static final String GAME_MENU_LABEL = "Menu";
	private static final String RESUME_LABEL = "Resume";
	private static final String PAUSE_LABEL = "Pause";

	private GameEngine engine;
	private GamePanel gamePanel;
	private GameFrame gameFrame;

	private JMenuItem pauseMenuItem;

	public GameMenu(GameEngine engine, GamePanel gamePanel, GameFrame gameFrame) {
		super(GAME_MENU_LABEL);
		this.engine = engine;
		this.gamePanel = gamePanel;
		this.gameFrame = gameFrame;

		setMnemonic('m');
		addRestartMenuItem();
		addPauseMenuItem();
	}

	private void addRestartMenuItem() {
		JMenuItem restartMenuItem = new JMenuItem(NEW_GAME_LABEL);
		restartMenuItem.setMnemonic('N');
		restartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.ALT_MASK));
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrame.startNewGame();
				setPauseMenuItemText();
			}
		});
		add(restartMenuItem);
	}

	private void addPauseMenuItem() {
		pauseMenuItem = new JMenuItem("Pause");
		pauseMenuItem.setMnemonic('p');
		pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.ALT_MASK));
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.togglePause();
				setPauseMenuItemText();
				gamePanel.updateFields();
			}
		});
		add(pauseMenuItem);
	}

	private void setPauseMenuItemText() {
		pauseMenuItem.setText(engine.isPaused() ? RESUME_LABEL : PAUSE_LABEL);
	}
}
