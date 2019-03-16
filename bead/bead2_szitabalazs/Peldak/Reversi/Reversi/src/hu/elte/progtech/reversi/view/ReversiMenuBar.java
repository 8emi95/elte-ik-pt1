package hu.elte.progtech.reversi.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import hu.elte.progtech.reversi.model.ReversiEngine;

public class ReversiMenuBar extends JMenuBar {

	private static final long serialVersionUID = 2328799216530065931L;

	private static final String GAME = "Game";
	private static final String NEW = "New";

	public ReversiMenuBar(ReversiEngine engine) {
		JMenu menu = new JMenu(GAME);
		menu.add(createNewGameMenuItem(engine));
		add(menu);
	}

	private JMenuItem createNewGameMenuItem(ReversiEngine engine) {
		JMenuItem newGame = new JMenuItem(NEW);
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.startNewGame();
			}
		});
		return newGame;
	}

}
