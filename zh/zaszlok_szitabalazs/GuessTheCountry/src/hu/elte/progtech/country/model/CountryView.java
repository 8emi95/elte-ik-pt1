package hu.elte.progtech.country.model;

import java.util.List;

public interface CountryView {

	void newGameStarted(List<Country> countries);

	void puzzleGenerated();

	void guessEvaluated(boolean goodGuess);

}
