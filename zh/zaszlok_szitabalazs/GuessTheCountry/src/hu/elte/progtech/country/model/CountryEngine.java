package hu.elte.progtech.country.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountryEngine {

	private static final int MIN_COUNTRIES = 3;

	private CountryView view;
	private List<Country> countries;
	private Country puzzle;
	private int allGuesses = 0;
	private int goodGuesses = 0;

	public void setView(CountryView view) {
		this.view = view;
	}

	public void startNewGame(File selectedFile) throws IOException {
		parseFile(selectedFile);
		puzzle = null;
		allGuesses = 0;
		goodGuesses = 0;
		view.newGameStarted(countries);
	}

	private void parseFile(File selectedFile) throws IOException, IndexOutOfBoundsException {
		countries = new ArrayList<>();
		addCountries(selectedFile);
		if (countries.size() < MIN_COUNTRIES) {
			throw new IOException("Too few countries");
		}
	}

	private void addCountries(File selectedFile) throws IOException, FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
			for (String line; (line = reader.readLine()) != null;) {
				addCountry(line);
			}
		}
	}

	private void addCountry(String line) throws IOException {
		try {
			int lastSpace = line.lastIndexOf(' ');
			String fileName = line.substring(lastSpace + 1);
			if (!Files.exists(Paths.get(fileName))) {
				throw new IOException(fileName + "is not a file");
			}
			countries.add(new Country(line.substring(0, lastSpace), fileName));
		} catch (IndexOutOfBoundsException ex) {
			throw new IOException("Bad file format (no file names)");
		}
	}

	public void generatePuzzle() {
		Random random = new Random();
		puzzle = countries.get(random.nextInt(countries.size()));
		view.puzzleGenerated();
	}

	public void guess(Country selectedValue) {
		boolean goodGuess = selectedValue.equals(puzzle);
		incrementGuesses(goodGuess);
		view.guessEvaluated(goodGuess);
	}

	private void incrementGuesses(boolean goodGuess) {
		++allGuesses;
		if (goodGuess) {
			++goodGuesses;
		}
	}

	public String getPuzzleFile() {
		return puzzle.getImageFile();
	}

	public int getAllGuesses() {
		return allGuesses;
	}

	public int getGoodGuesses() {
		return goodGuesses;
	}

}
