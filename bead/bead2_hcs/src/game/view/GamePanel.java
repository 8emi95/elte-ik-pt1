package game.view;

import static game.engine.Player.NOBODY;
import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.engine.GameEngine;
import game.engine.Player;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int FIELD_WIDTH = 60;
	private static final int FIELD_HEIGHT = 60;
	private static final String WON_TEXT = " won the game!\nWanna play again?";
	private static final String GAME_OVER_TITLE = "Game over";

	private ImageIcon playerOne = new PlayerOneIcon(FIELD_WIDTH, FIELD_HEIGHT);
	private ImageIcon playerTwo = new PlayerTwoIcon(FIELD_WIDTH, FIELD_HEIGHT);

	private GameEngine engine;

	public GamePanel(GameEngine engine, GameFrame gameFrame) {
		this.engine = engine;
	}

	public void startNewGame() {
		removeAll();
		setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		this.createFields();
		this.updateFields();
	}

	private void createFields() {
		int size = engine.getSize();
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				add(createField(i, j));
			}
		}
	}

	private Component createField(int row, int column) {
		JButton field = new JButton();
		field.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
		field.setBackground(getFieldBackground(row, column));

		field.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				engine.actionInField(row, column);
				updateFields();
				if (engine.gameWon()) {
					showWinDialog(engine.getWinner());
				}
			}
		});
		return field;
	}

	private Color getFieldBackground(int row, int column) {
		return row % 2 == column % 2 ? WHITE : GRAY;
	}

	public void updateFields() {
		int fields = engine.getSize();
		for (int i = 0; i < fields; ++i) {
			for (int j = 0; j < fields; ++j) {
				updateField(i, j);
			}
		}
	}

	private void updateField(int row, int column) {
		int fields = engine.getSize();
		JButton field = (JButton) getComponent(row * fields + column);
		Player player = engine.getPlayer(row, column);
		setFieldIcon(field, player);
		setFieldBackground(field, player, row, column);
	}

	private void setFieldIcon(JButton field, Player player) {
		if (!engine.isPaused()) {
			switch (player) {
			case ONE:
				field.setIcon(playerOne);
				break;
			case TWO:
				field.setIcon(playerTwo);
				break;
			case NOBODY:
				field.setIcon(new ImageIcon());
				break;
			}
		} else {
			field.setIcon(new ImageIcon());
		}
	}

	private void setFieldBackground(JButton field, Player player, int row, int column) {
		Player actualPlayer = engine.getActualPlayer();
		if (engine.isPaused()) {
			field.setBackground(Color.DARK_GRAY);
			return;
		}
		if (actualPlayer != NOBODY && actualPlayer == player) {
			field.setBackground(new Color(0, 255, 0));
		} else {
			field.setBackground(getFieldBackground(row, column));
		}
	}

	protected void showWinDialog(Player player) {
		String playerName = getWinnerName(player);
		int answer = JOptionPane.showConfirmDialog(this, playerName + WON_TEXT, GAME_OVER_TITLE, JOptionPane.YES_NO_OPTION);
		if (JOptionPane.YES_OPTION == answer)
			restartGame();
	}

	private String getWinnerName(Player player)  {
		switch (player) {
		case ONE:
			return ((PlayerIcon) playerOne).getName();
		case TWO:
			return ((PlayerIcon) playerTwo).getName();
		default:
			throw new IllegalArgumentException("Nobody has won the game!");
		}
	}

	public void restartGame() {
		engine.startNewGame(engine.getSize());
		startNewGame();
	}
}
