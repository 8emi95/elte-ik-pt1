package hu.elte.progtech.reversi.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.LINE_END;
import static java.awt.BorderLayout.LINE_START;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Font.BOLD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hu.elte.progtech.reversi.model.ReversiColor;

public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 4368784672413791810L;

	private JLabel blackArrow;
	private JLabel whiteArrow;

	private JLabel blackScore;
	private JLabel whiteScore;

	private JLabel blackWins;
	private JLabel whiteWins;

	private JLabel timeRemaining;

	public ResultPanel() {
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, BLACK));
		setLayout(new BorderLayout());
		add(createArrows(), NORTH);
		add(createScores(), CENTER);
		add(createWins(), SOUTH);
	}

	private Container createScores() {
		Container scores = new Container();
		scores.setLayout(new BorderLayout());
		blackScore = createScoreLabel(BLACK);
		timeRemaining = createTimeRemainingLabel();
		whiteScore = createScoreLabel(WHITE);
		scores.add(blackScore, LINE_START);
		scores.add(timeRemaining, CENTER);
		scores.add(whiteScore, LINE_END);
		return scores;
	}

	private Container createArrows() {
		Container arrows = new Container();
		arrows.setLayout(new BorderLayout());
		blackArrow = createArrowLabel(BLACK);
		whiteArrow = createArrowLabel(WHITE);
		arrows.add(blackArrow, LINE_START);
		arrows.add(whiteArrow, LINE_END);
		return arrows;
	}

	private Container createWins() {
		Container wins = new Container();
		wins.setLayout(new BorderLayout());
		blackWins = createWinLabel(BLACK);
		whiteWins = createWinLabel(WHITE);
		wins.add(blackWins, LINE_START);
		wins.add(whiteWins, LINE_END);
		return wins;
	}

	private JLabel createArrowLabel(Color color) {
		JLabel arrow = new JLabel();
		arrow.setHorizontalAlignment(SwingConstants.CENTER);
		arrow.setForeground(color);
		arrow.setText("▼");
		arrow.setFont(arrow.getFont().deriveFont(10.0f));
		arrow.setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 24));
		return arrow;
	}

	private JLabel createScoreLabel(Color color) {
		JLabel score = new JLabel();
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setForeground(color);
		score.setFont(score.getFont().deriveFont(25.0f).deriveFont(BOLD));
		score.setBorder(BorderFactory.createEmptyBorder(4, 24, 4, 24));
		return score;
	}

	private JLabel createTimeRemainingLabel() {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(label.getFont().deriveFont(BOLD));
		return label;
	}

	private JLabel createWinLabel(Color color) {
		JLabel wins = new JLabel();
		wins.setHorizontalAlignment(SwingConstants.CENTER);
		wins.setForeground(color);
		wins.setFont(wins.getFont().deriveFont(10.0f).deriveFont(BOLD));
		wins.setBorder(BorderFactory.createEmptyBorder(0, 24, 0, 24));
		return wins;
	}

	public void updateArrows(ReversiColor currentPlayer) {
		blackArrow.setVisible(ReversiColor.BLACK.equals(currentPlayer));
		whiteArrow.setVisible(ReversiColor.WHITE.equals(currentPlayer));
	}

	public void updateScores(int blackFields, int whiteFields, double blackOverall, double whiteOverall) {
		blackScore.setText(Integer.toString(blackFields));
		blackWins.setText("(" + blackOverall + ")");
		whiteScore.setText(Integer.toString(whiteFields));
		whiteWins.setText("(" + whiteOverall + ")");
	}

	public void updateTimeToPut(int secondsRemaining) {
		timeRemaining.setText(Integer.toString(secondsRemaining));
	}

}
