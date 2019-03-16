package hu.elte.progtech.reversi.view;

import static hu.elte.progtech.reversi.model.ReversiColor.BLACK;
import static hu.elte.progtech.reversi.model.ReversiColor.WHITE;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.GRAY;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hu.elte.progtech.reversi.model.ReversiColor;
import hu.elte.progtech.reversi.model.ReversiEngine;
import hu.elte.progtech.reversi.model.ReversiView;

public class ReversiFrame extends JFrame implements ReversiView {

	private static final long serialVersionUID = 3562080391190665365L;

	private static final String ENDGAME_TITLE = "End of game";
	private static final String DRAW_MESSAGE = "It's a draw";
	private static final String WINNER_MESSAGE = "%s wins";
	private static final String EMPTY = "";
	private static final String STONE = "●";

	private ReversiEngine engine;
	private ResultPanel resultPanel;
	private Container board;
	private StatusBar statusBar;

	public ReversiFrame() {
		super("Reversi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setModel(ReversiEngine engine) {
		this.engine = engine;
	}

	public void showFrame() {
		setJMenuBar(new ReversiMenuBar(engine));
		addResultPanel();
		addBoard();
		addStatusBar();
		setVisible(true);
		pack();
	}

	private void addResultPanel() {
		resultPanel = new ResultPanel();
		getContentPane().add(resultPanel, NORTH);
	}

	private void addBoard() {
		board = new Container();
		board.setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				addField(i, j);
			}
		}
		getContentPane().add(board, CENTER);
	}

	private void addField(int row, int column) {
		JButton field = new JButton();
		field.setBackground(GRAY);
		field.setPreferredSize(new Dimension(40, 40));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setMargin(new Insets(0, 0, 0, 0));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.put(row, column);
			}
		});
		board.add(field);
	}

	private void addStatusBar() {
		statusBar = new StatusBar();
		getContentPane().add(statusBar, SOUTH);
	}

	@Override
	public void update(int row, int column) {
		JButton field = (JButton) board.getComponent(row * engine.getSize() + column);
		setLabelOfField(field, row, column);
	}

	private void setLabelOfField(JButton field, int row, int column) {
		if (BLACK.equals(engine.getField(row, column))) {
			field.setText(STONE);
			field.setForeground(Color.BLACK);
		} else if (WHITE.equals(engine.getField(row, column))) {
			field.setText(STONE);
			field.setForeground(Color.WHITE);
		} else {
			field.setText(EMPTY);
		}
	}

	@Override
	public void nextTurn(ReversiColor who) {
		statusBar.setText(who.toString() + "'s turn");
		resultPanel.updateScores(engine.getBlackFields(), engine.getWhiteFields(), engine.getBlackWins(),
				engine.getWhiteWins());
		resultPanel.updateArrows(who);
		resultPanel.updateTimeToPut(engine.getSecondsRemaining());
	}

	@Override
	public void cantPutHere() {
		statusBar.setText("Can't put here");
	}

	@Override
	public void samePlayerNextTurn(ReversiColor who) {
		statusBar.setText("Other player can't put, still " + who.toString() + "'s turn");
	}

	@Override
	public void endGame(ReversiColor winner) {
		statusBar.setText(ENDGAME_TITLE);
		resultPanel.updateScores(engine.getBlackFields(), engine.getWhiteFields(), engine.getBlackWins(),
				engine.getWhiteWins());
		resultPanel.updateArrows(ReversiColor.EMPTY);
		askNewGame(winner);
	}

	private void askNewGame(ReversiColor winner) {
		int newGame = JOptionPane.showConfirmDialog(this, getEndOfGameMessage(winner), ENDGAME_TITLE, YES_NO_OPTION);
		if (YES_OPTION == newGame) {
			engine.startNewGame();
		}
	}

	private String getEndOfGameMessage(ReversiColor winner) {
		return getWinnerMessage(winner) + "\nPlay again?";
	}

	private String getWinnerMessage(ReversiColor winner) {
		if (ReversiColor.EMPTY.equals(winner)) {
			return DRAW_MESSAGE;
		}
		return String.format(WINNER_MESSAGE, winner.toString());
	}

	@Override
	public void updateTime(int time) {
		statusBar.updateTime(time);
	}

	@Override
	public void updateTimeToPut(int time) {
		resultPanel.updateTimeToPut(time);
	}

}
