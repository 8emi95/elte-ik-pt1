package hu.elte.progtech.mastermind.model;

public interface MastermindView {

	void initializeGame();

	void update(int guess, int item, int value);

	void updateLine(int guess);

	void endGame(boolean success);

	void evaluateGuess(GuessEvaluator verdict);

}
