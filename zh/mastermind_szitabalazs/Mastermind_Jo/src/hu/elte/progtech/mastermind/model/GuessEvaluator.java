package hu.elte.progtech.mastermind.model;

import static hu.elte.progtech.mastermind.model.MastermindEngine.COLORS;

import java.util.HashMap;
import java.util.Map;

public class GuessEvaluator {

	private int guessNumber;
	private int[] guess;
	private int[] puzzle;

	private int matchedColors = 0;
	private int wellPlaced = 0;
	private Map<Integer, Integer> distributionInGuess = new HashMap<>();
	private Map<Integer, Integer> distributionInPuzzle = new HashMap<>();

	public GuessEvaluator(int guessNumber, int[] guess, int[] puzzle) {
		this.guessNumber = guessNumber;
		this.guess = guess;
		this.puzzle = puzzle;
	}

	public boolean evaluate() {
		computeDistributionAndWellPlaced();
		computeAllMatched();
		substractWellPlacedFromAllMatched();
		return wellPlaced == COLORS;
	}

	private void computeDistributionAndWellPlaced() {
		for (int item = 0; item < COLORS; ++item) {
			distributionInGuess.put(guess[item], getCountOfValue(distributionInGuess, guess[item]) + 1);
			distributionInPuzzle.put(puzzle[item], getCountOfValue(distributionInPuzzle, puzzle[item]) + 1);
			if (guess[item] == puzzle[item]) {
				++wellPlaced;
			}
		}
	}

	private Integer getCountOfValue(Map<Integer, Integer> map, int value) {
		Integer count = map.get(value);
		return count == null ? 0 : count;
	}

	private void computeAllMatched() {
		for (int color = 1; color <= COLORS; ++color) {
			matchedColors += Math.min(getCountOfValue(distributionInGuess, color),
					getCountOfValue(distributionInPuzzle, color));
		}
	}

	private void substractWellPlacedFromAllMatched() {
		matchedColors -= wellPlaced;
	}

	public int getGuessNumber() {
		return guessNumber;
	}

	public int getWellPlaced() {
		return wellPlaced;
	}

	public int getMatchedColors() {
		return matchedColors;
	}

}
