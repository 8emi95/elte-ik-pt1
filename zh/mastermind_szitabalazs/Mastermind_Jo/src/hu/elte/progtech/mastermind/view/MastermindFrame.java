package hu.elte.progtech.mastermind.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hu.elte.progtech.mastermind.model.GuessEvaluator;
import hu.elte.progtech.mastermind.model.MastermindEngine;
import hu.elte.progtech.mastermind.model.MastermindView;

public class MastermindFrame extends JFrame implements MastermindView {

	private static final long serialVersionUID = 8088978051608863877L;

	private static final String GUESS_LABEL = "TIPP";
	private static final String LABEL_TEMPLATE = "well-placed: %d, matched: %d ";
	private static final String END = "End of the game";
	private static final String PR0 = "You won! ";
	private static final String N00B = "You lost :( ";
	private static final String PLAY_AGAIN = "Wanna play again?";

	private MastermindEngine engine;
	private List<Color> colors;
	private Container topPart;
	private Container bottomPart;
	private JButton guessButton;

	public MastermindFrame() {
		super("Mastermind");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setModel(MastermindEngine engine) {
		this.engine = engine;
	}

	public void showFrame() {
		setVisible(true);
	}

	@Override
	public void startNewGame() {
		selectColors();
		addTopPart();
		addBottomPart();
		pack();
		showCheat();
	}

	private void selectColors() {
		colors = new ArrayList<>(6);
		colors.add(RED);
		colors.add(GREEN);
		colors.add(BLUE);
		colors.add(YELLOW);
		colors.add(WHITE);
		colors.add(BLACK);
		Collections.shuffle(colors);
		colors.removeAll(colors.subList(0, colors.size() - engine.getColorCount()));
	}

	private void addTopPart() {
		if (topPart != null) {
			getContentPane().remove(topPart);
		}
		topPart = new Container();
		topPart.setLayout(new GridLayout(engine.getGuessCount(), engine.getColorCount() + 1));
		for (int i = 0; i < engine.getGuessCount(); ++i) {
			for (int j = 0; j < engine.getColorCount(); ++j) {
				addButton(i, j);
			}
			addGuessLabel(i);
		}
		getContentPane().add(topPart, NORTH);
	}

	private void addButton(int i, int j) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(30, 30));
		button.setEnabled(engine.getCurrentGuess() == i);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.clicked(i, j);
			}
		});
		topPart.add(button);
	}

	private void addGuessLabel(int i) {
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(150, label.getPreferredSize().height));
		topPart.add(label);
	}

	@Deprecated
	private void showCheat() {
		System.out.println("Color-value mapping:");
		System.out.println("  0: blank");
		for (int i = 0; i < colors.size(); ++i) {
			System.out.println(String.format("  %d: %s", i + 1, colors.get(i).toString()));
		}
	}

	private void addBottomPart() {
		if (bottomPart != null) {
			getContentPane().remove(bottomPart);
		}
		bottomPart = new Container();
		bottomPart.setLayout(new BorderLayout());
		guessButton = new JButton(GUESS_LABEL);
		guessButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.guess();
			}
		});
		bottomPart.add(guessButton, CENTER);
		getContentPane().add(bottomPart, SOUTH);
	}

	@Override
	public void update(int guess, int item, int value) {
		getButton(guess, item).setBackground(getBackgroundOfButton(value));
	}

	private JButton getButton(int guess, int item) {
		Component component = topPart.getComponent((guess * (engine.getColorCount() + 1)) + item);
		return (JButton) component;
	}

	private Color getBackgroundOfButton(int value) {
		return colors.get(value - 1);
	}

	@Override
	public void updateLine(int guess) {
		for (int item = 0; item < engine.getColorCount(); ++item) {
			getButton(guess, item).setEnabled(guess == engine.getCurrentGuess());
		}
	}

	@Override
	public void endGame(boolean success) {
		guessButton.setEnabled(false);
		int answer = JOptionPane.showConfirmDialog(this, getEndGameMessage(success), END, YES_NO_OPTION);
		if (answer == YES_OPTION) {
			engine.startNewGame();
		}
	}

	private String getEndGameMessage(boolean success) {
		return (success ? PR0 : N00B) + PLAY_AGAIN;
	}

	@Override
	public void evaluateGuess(GuessEvaluator verdict) {
		JLabel label = getLabel(verdict.getGuessNumber());
		label.setText(String.format(LABEL_TEMPLATE, verdict.getWellPlaced(), verdict.getMatchedColors()));
	}

	private JLabel getLabel(int guess) {
		Component component = topPart.getComponent((guess + 1) * (engine.getColorCount() + 1) - 1);
		return (JLabel) component;
	}

}
