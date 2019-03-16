package hu.elte.progtech.country.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import hu.elte.progtech.country.model.Country;
import hu.elte.progtech.country.model.CountryEngine;
import hu.elte.progtech.country.model.CountryView;

public class CountryFrame extends JFrame implements CountryView {

	private final CountryEngine engine;
	private FlagFileBrowserButton fileBrowser;
	private MiddlePart middlePart;
	private JLabel statisticsLabel;

	public CountryFrame(CountryEngine engine) {
		this.engine = engine;
		addFileBrowserButton();
		addMiddlePart();
		addStatisticsLabel();
		pack();
	}

	private void addFileBrowserButton() {
		fileBrowser = new FlagFileBrowserButton(this, engine);
		getContentPane().add(fileBrowser, BorderLayout.NORTH);
	}

	private void addMiddlePart() {
		middlePart = new MiddlePart(engine);
		getContentPane().add(middlePart, BorderLayout.CENTER);
	}

	private void addStatisticsLabel() {
		statisticsLabel = new JLabel("Válassz egy fájlt");
		getContentPane().add(statisticsLabel, BorderLayout.SOUTH);
	}

	@Override
	public void newGameStarted(List<Country> countries) {
		middlePart.clearLastGame();
		middlePart.updateCountries(countries);
		middlePart.prepareNextPuzzle();
		updateStatisticsLabel();
	}

	@Override
	public void puzzleGenerated() {
		middlePart.puzzleGenerated();
		updateStatisticsLabel();
	}

	@Override
	public void guessEvaluated(boolean goodGuess) {
		middlePart.prepareNextPuzzle();
		updateStatisticsLabel(goodGuess);
	}

	private void updateStatisticsLabel() {
		statisticsLabel.setText(engine.getGoodGuesses() + "/" + engine.getAllGuesses());
	}

	private void updateStatisticsLabel(boolean goodGuess) {
		statisticsLabel.setText(goodGuess ? "Eltaláltad, cula!" : "Nem találtad el, cula!");
	}

}
