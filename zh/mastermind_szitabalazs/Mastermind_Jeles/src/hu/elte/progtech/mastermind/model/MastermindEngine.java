package hu.elte.progtech.mastermind.model;

import java.util.Random;
import java.util.StringJoiner;

public class MastermindEngine {

	private static final int ITEMS = 4;
	private static final int GUESSES = 10;
	private static final int[] AVAILABLE_COLORS = { 4, 5, 6 };

	private static final Random RANDOM = new Random(System.currentTimeMillis());

	private MastermindView view;
	private int colors;
	private int[] puzzle;
	private int[][] guesses;
	private int currentGuess;

	public void setView(MastermindView view) {
		this.view = view;
	}

	public void startNewGame(int colors) {
		this.colors = colors;
		generatePuzzle();
		clearGuesses();
		currentGuess = 0;
		showCheat();
		view.initializeGame();
	}

	private void generatePuzzle() {
		puzzle = new int[ITEMS];
		for (int i = 0; i < ITEMS; ++i) {
			puzzle[i] = RANDOM.nextInt(colors) + 1;
		}
	}

	private void clearGuesses() {
		guesses = new int[GUESSES][ITEMS];
	}

	@Deprecated
	private void showCheat() {
		System.out.print("Puzzle: <");
		StringJoiner joiner = new StringJoiner(", ");
		for (int item : puzzle) {
			joiner.add(Integer.toString(item));
		}
		System.out.print(joiner.toString());
		System.out.println(">");
	}

	public int getGuessCount() {
		return GUESSES;
	}

	public int getColorCount() {
		return colors;
	}

	public void clicked(int guess, int item) {
		view.update(guess, item, increment(guess, item));
	}

	private int increment(int guess, int item) {
		if (guesses[guess][item] == colors) {
			guesses[guess][item] = 1;
		} else {
			++guesses[guess][item];
		}
		return guesses[guess][item];
	}

	public int getCurrentGuess() {
		return currentGuess;
	}

	public void guess() {
		boolean success = evaluateGuess();
		++currentGuess;
		view.updateLine(currentGuess - 1);
		if (success) {
			view.endGame(true);
		} else {
			prepareNextGuess();
		}
	}

	private boolean evaluateGuess() {
		GuessEvaluator evaluator = new GuessEvaluator(ITEMS, colors, currentGuess, guesses[currentGuess], puzzle);
		boolean verdict = evaluator.evaluate();
		view.evaluateGuess(evaluator);
		return verdict;
	}

	private void prepareNextGuess() {
		if (currentGuess == GUESSES) {
			view.endGame(false);
		} else {
			view.updateLine(currentGuess);
		}
	}

	public int[] getAvailableColors() {
		return AVAILABLE_COLORS;
	}

	public int getItemCount() {
		return ITEMS;
	}

}
