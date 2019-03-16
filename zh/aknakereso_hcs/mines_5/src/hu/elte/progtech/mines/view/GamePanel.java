package hu.elte.progtech.mines.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import hu.elte.progtech.mines.model.MinesEngine;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int FIELD_SIZE = 65;
	private static final String PLAYER_SYMBOL = "X";
	private static final String WON_TEXT = "You won the game!\nWanna play again?";
	private static final String GAME_OVER_TITLE = "Game over";
	private static final String LOOSE_TEXT = "Sorry, You loose !";

	private MinesEngine engine;
	private InfoPanel infoPanel;

	private Timer gameTimer;

	public GamePanel(MinesEngine engine, InfoPanel infoPanel) {
		this.engine = engine;
		this.infoPanel = infoPanel;
		setLayout(new GridLayout(engine.getSize(), engine.getSize()));

		gameTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (engine.timeIsUp()) {
					showLooseDialog();
				}
			}
		});
		gameTimer.start();
		addFields();
	}

	private void addFields() {
		int size = engine.getSize();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				addField(i, j);
			}
		}
	}

	private void addField(int row, int column) {
		JButton field = createField(row, column);
		add(field);
	}

	private JButton createField(int row, int column) {
		JButton field = new JButton();
		if (engine.isPlayerPosition(row, column)) {
			field.setText(PLAYER_SYMBOL);
		}
		field.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getBackgroundColor(row, column));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!engine.isPaused() && engine.moveTo(row, column)) {
					infoPanel.setSteps(engine.getSteps());
					updateFields();
					if (engine.isBlownUp()) {
						showLooseDialog();
					}
					if (engine.isWon()) {
						showWinDialog();
					}
				}
			}
		});
		return field;
	}

	private Color getBackgroundColor(int row, int column) {
		if (engine.isPaused()) {
			return GRAY;
		}
		return engine.isInPath(row, column) ? GREEN
				: (engine.isPlayerPosition(row, column) && engine.isBlownUp()) ? Color.RED : WHITE;
	}

	public void updateFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
				updateField(i, j);
			}
		}
	}

	private void updateField(int row, int column) {
		JButton field = (JButton) getComponent(row * engine.getSize() + column);
		field.setText(getFieldText(row, column));
		field.setBackground(getBackgroundColor(row, column));
	}

	private String getFieldText(int row, int column) {
		return !engine.isPaused() && engine.isPlayerPosition(row, column) ? PLAYER_SYMBOL : "";
	}

	protected void showWinDialog() {
		int answer = JOptionPane.showConfirmDialog(this, WON_TEXT, GAME_OVER_TITLE, JOptionPane.YES_NO_OPTION);
		if (JOptionPane.YES_OPTION == answer)
			restartGame();
	}

	protected void showLooseDialog() {
		JOptionPane.showMessageDialog(this, LOOSE_TEXT, GAME_OVER_TITLE, JOptionPane.INFORMATION_MESSAGE);
		restartGame();
	}

	public void restartGame() {
		engine.startGame();
		infoPanel.setSteps(0);
		updateFields();
	}
}
