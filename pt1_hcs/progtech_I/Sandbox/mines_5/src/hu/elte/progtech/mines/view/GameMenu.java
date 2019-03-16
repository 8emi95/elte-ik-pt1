package hu.elte.progtech.mines.view;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import hu.elte.progtech.mines.model.MinesEngine;

public class GameMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private static final String GAME_MENU_LABEL = "Menu";
	private static final String RESUME_LABEL = "Resume";
	private static final String PAUSE_LABEL = "Pause";

	private MinesEngine engine;
	private GamePanel gamePanel;

	private JMenuItem pauseMenuItem;

	public GameMenu(MinesEngine engine, GamePanel gamePanel) {
		super(GAME_MENU_LABEL);
		this.engine = engine;
		this.gamePanel = gamePanel;

		setMnemonic('m');
		addRestartMenuItem();
		addPauseMenuItem();
	}

	private void addRestartMenuItem() {
		JMenuItem restartMenuItem = new JMenuItem("Restart");
		restartMenuItem.setMnemonic('R');
		restartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.ALT_MASK));
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.restartGame();
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
