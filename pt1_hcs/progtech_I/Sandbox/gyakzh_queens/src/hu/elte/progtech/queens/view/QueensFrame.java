package hu.elte.progtech.queens.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import hu.elte.progtech.queens.model.QueensEngine;

public class QueensFrame extends JFrame {

	private static final String MENU_LABEL = "Game";
	private static final String RESUME_LABEL = "Resume";
	private static final String PAUSE_LABEL = "Pause";
	private static final String WIN_TITLE = "Congratulations!";
	private static final String WIN_TEXT = "You win!\nWanna play another game?";
	private static final String EMPTY_LABEL = "";
	private static final String QUEEN_LABEL = "Q";

	private static final long serialVersionUID = 1L;

	private QueensEngine engine;
	private JMenuItem pauseMenuItem;

	public QueensFrame(QueensEngine engine) {
		super("Progtech queens gyakZH");
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

	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu(MENU_LABEL);
		menu.setMnemonic('m');
		;
		menuBar.add(menu);
		addRestartMenuItem(menu);
		addUndoMenuItem(menu);
		addPauseMenuItem(menu);
		setJMenuBar(menuBar);
	}

	private void addRestartMenuItem(JMenu menu) {
		JMenuItem restartMenuItem = new JMenuItem("Restart");
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
				setPauseMenuItemText();
			}

		});
		restartMenuItem.setMnemonic('r');
		restartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.ALT_MASK));
		menu.add(restartMenuItem);
	}

	private void setPauseMenuItemText() {
		pauseMenuItem.setText(engine.isPaused() ? RESUME_LABEL : PAUSE_LABEL);
	}

	private void addUndoMenuItem(JMenu menu) {
		JMenuItem undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!engine.isPaused()) {
					engine.undo();
					updateFields();
				}
			}
		});
		undoMenuItem.setMnemonic('u');
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.ALT_MASK));
		menu.add(undoMenuItem);
	}

	private void addPauseMenuItem(JMenu menu) {
		pauseMenuItem = new JMenuItem(PAUSE_LABEL);
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.togglePause();
				setPauseMenuItemText();
				updateFields();
			}
		});
		menu.add(pauseMenuItem);
		pauseMenuItem.setMnemonic('p');
		pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.ALT_MASK));
	}

	private void startNewGame() {
		engine.startGame();
		updateFields();
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
				addField(i, j);
			}
		}
	}

	private void addField(int i, int j) {
		JButton field = createField(i, j);
		getContentPane().add(field);
	}

	private JButton createField(int i, int j) {
		JButton field = new JButton();
		field.setPreferredSize(new Dimension(65, 65));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getFieldBackground(i, j));
		field.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!engine.isPaused() && engine.putQueen(i, j)) {
					updateFields();
					if (engine.isWon()) {
						askForAnotherGame();
					}
				}
			}
		});
		return field;
	}

	protected void askForAnotherGame() {
		int answer = JOptionPane.showConfirmDialog(this, WIN_TEXT, WIN_TITLE, YES_NO_OPTION);
		if (answer == YES_OPTION) {
			startNewGame();
		}
	}

	private Color getFieldBackground(int row, int column) {
		if (engine.isPaused()) {
			return row % 2 == column % 2 ? WHITE : GRAY;
		}
		return engine.isAvailableToPut(row, column) ? GREEN : row % 2 == column % 2 ? WHITE : GRAY;
	}

	protected void updateFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
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
		return engine.isPaused() ? EMPTY_LABEL : engine.isQueen(row, column) ? QUEEN_LABEL : EMPTY_LABEL;
	}
}
