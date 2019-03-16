package hu.elte.progtech.mines.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import hu.elte.progtech.mines.model.MinesEngine;

public class MinesFrame extends JFrame {
	private static final String WON_TEXT = "You won the game!\nWanna play again?";
	private static final String GAME_OVER_TITLE = "Game over";
	private static final String LOOSE_TEXT = "Sorry, You loose !";
	private static final String GAME_MENU_LABEL = "Menu";
	private static final String PLAYER_SYMBOL = "X";
	private static final int FIELD_SIZE = 65;
	private static final long serialVersionUID = 1L;
	private static final String RESUME_LABEL = "Resume";
	private static final String PAUSE_LABEL = "Pause";
	private MinesEngine engine;
	private JMenuItem pauseMenuItem;

	public MinesFrame(MinesEngine engine) {
		super("progtech Mines zh");
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
		JMenu menu = new JMenu(GAME_MENU_LABEL);
		menu.setMnemonic('m');
		menuBar.add(menu);
		addRestartMenuItem(menu);
		addPauseMenuItem(menu);
		setJMenuBar(menuBar );
	}

	private void addRestartMenuItem(JMenu menu) {
		JMenuItem restartMenuItem = new JMenuItem("Restart");
		restartMenuItem.setMnemonic('R');
		restartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.ALT_MASK));
		restartMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		menu.add(restartMenuItem );
	}

	private void addPauseMenuItem(JMenu menu) {
		pauseMenuItem = new JMenuItem("Pause");
		pauseMenuItem.setMnemonic('p');
		pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.ALT_MASK));
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.togglePause();
				setPauseMenuItemText();
				updateFields();
			}
		});
		menu.add(pauseMenuItem);
	}
	
	private void setPauseMenuItemText() {
		pauseMenuItem.setText(engine.isPaused() ? RESUME_LABEL : PAUSE_LABEL);
	}


	protected void restartGame() {
		engine.startGame();
		updateFields();
		setPauseMenuItemText();
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
				addField(i, j);
			}
		}
	}

	private void addField(int row, int column) {
		JButton field = createField(row, column);
		getContentPane().add(field);
	}

	private JButton createField(int row, int column) {
		JButton field = new JButton();
		if (engine.isPlayersPosition(row, column)) {
			field.setText(PLAYER_SYMBOL);
		}
		field.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getBackgroundColor(row, column));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!engine.isPaused() && engine.moveTo(row, column)){
					updateFields();
					if(engine.isBlownUp()){
						showLooseDialog();
					}
					if(engine.isWon()){
						showWinDialog();
					}
				}
			}
		});
		return field;
	}

	protected void showWinDialog() {
		int answer = JOptionPane.showConfirmDialog(this, WON_TEXT, GAME_OVER_TITLE, JOptionPane.YES_NO_OPTION);
		if( JOptionPane.YES_OPTION == answer)
			restartGame();
	}

	protected void showLooseDialog() {
		JOptionPane.showMessageDialog(this, LOOSE_TEXT, GAME_OVER_TITLE, JOptionPane.INFORMATION_MESSAGE);
		restartGame();
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
		field.setText(getFieldText(row, column));
		field.setBackground(getBackgroundColor(row, column));
	}

	private String getFieldText(int row, int column) {
		return !engine.isPaused() && engine.isPlayersPosition(row, column) ? PLAYER_SYMBOL : "";
	}

	private Color getBackgroundColor(int row, int column) {
		if (engine.isPaused()){
			return GRAY;
		}
		return engine.isInPath(row, column) ? GREEN : (engine.isPlayersPosition(row, column) && engine.isBlownUp() ) ? Color.RED : WHITE;
	}

}
