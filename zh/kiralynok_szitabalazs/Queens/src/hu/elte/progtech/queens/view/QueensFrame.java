package hu.elte.progtech.queens.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import hu.elte.progtech.queens.model.QueensEngine;

public class QueensFrame extends JFrame {

	private static final long serialVersionUID = 2265228622194396011L;

	private static final String GAME_LABEL = "Game";
	private static final String RESTART_LABEL = "Restart";
	private static final String UNDO_LABEL = "Undo";
	private static final String PAUSE_LABEL = "Pause";
	private static final String RESUME_LABEL = "Resume";

	private static final String NEWGAME_TITLE = "You won";
	private static final String NEWGAME_QUESTION = "You won!\nWant to play again?";

	private static final String QUEEN = "♕";
	private static final String EMPTY = "";

	private QueensEngine engine;
	private JMenuItem pauseMenuItem;

	public QueensFrame(QueensEngine engine) {
		super("Queens");
		this.engine = engine;
	}

	public void showFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		addFields();
		addMenu();
		setVisible(true);
		pack();
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				addField(i, j);
			}
		}
	}

	private void addField(int row, int column) {
		JButton field = new JButton();
		field.setPreferredSize(new Dimension(65, 65));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getFieldBackground(row, column));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (engine.putQueen(row, column)) {
					updateFields();
					checkEndGame();
				}
			}
		});
		getContentPane().add(field);
	}

	private Color getFieldBackground(int row, int column) {
		if (engine.isPaused()) {
			return RED;
		} else if (engine.isAvailableToPut(row, column)) {
			return GREEN;
		} else {
			return isSameColor(row, column) ? WHITE : GRAY;
		}
	}

	private boolean isSameColor(int row, int column) {
		return row % 2 == column % 2;
	}

	private void updateFields() {
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				updateField(i, j);
			}
		}
	}

	private void updateField(int row, int column) {
		JButton field = (JButton) getContentPane().getComponent(row * engine.getSize() + column);
		field.setText(getFieldLabel(row, column));
		field.setBackground(getFieldBackground(row, column));
	}

	private String getFieldLabel(int row, int column) {
		return !engine.isPaused() && engine.isQueen(row, column) ? QUEEN : EMPTY;
	}

	private void checkEndGame() {
		if (engine.isWon() && wantToPlayAgain()) {
			startNewGame();
		}
	}

	private boolean wantToPlayAgain() {
		return YES_OPTION == JOptionPane.showConfirmDialog(this, NEWGAME_QUESTION, NEWGAME_TITLE, YES_NO_OPTION);
	}

	private void startNewGame() {
		engine.startNewGame();
		updateFields();
		updatePauseMenuItem();
	}

	private void updatePauseMenuItem() {
		pauseMenuItem.setText(engine.isPaused() ? RESUME_LABEL : PAUSE_LABEL);
	}

	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu(GAME_LABEL);
		menuBar.add(menu);
		menu.add(createRestartMenuItem());
		menu.add(createUndoMenuItem());
		pauseMenuItem = createPauseMenuItem();
		menu.add(pauseMenuItem);
		setJMenuBar(menuBar);
	}

	private JMenuItem createRestartMenuItem() {
		JMenuItem restartMenuItem = new JMenuItem(RESTART_LABEL);
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
		});
		return restartMenuItem;
	}

	private JMenuItem createUndoMenuItem() {
		JMenuItem undoMenuItem = new JMenuItem(UNDO_LABEL);
		undoMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.undo();
				updateFields();
			}
		});
		return undoMenuItem;
	}

	private JMenuItem createPauseMenuItem() {
		JMenuItem pauseMenuItem = new JMenuItem(PAUSE_LABEL);
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.togglePause();
				updatePauseMenuItem();
				updateFields();
			}
		});
		return pauseMenuItem;
	}

}
