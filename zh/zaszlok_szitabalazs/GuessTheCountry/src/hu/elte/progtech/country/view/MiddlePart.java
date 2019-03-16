package hu.elte.progtech.country.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import hu.elte.progtech.country.model.Country;
import hu.elte.progtech.country.model.CountryEngine;

public class MiddlePart extends Container {

	private static final long serialVersionUID = 1804468792015461425L;

	private static final String GUESS = "Tippelek";
	private static final String NEXT_PUZZLE = "Következő";

	private final GeneratePuzzleActionListener generateListener;
	private final GuessActionListener guessListener;

	private final CountryEngine engine;

	private JLabel puzzleFlag;
	private JList<Country> countryList;
	private JButton guessButton;

	public MiddlePart(CountryEngine engine) {
		this.engine = engine;
		setLayout(new BorderLayout());
		addPuzzleFlag();
		addCountryList();
		generateListener = new GeneratePuzzleActionListener(engine);
		guessListener = new GuessActionListener(countryList, engine);
		addGuessButton();
	}

	private void addPuzzleFlag() {
		puzzleFlag = new JLabel();
		puzzleFlag.setPreferredSize(new Dimension(600, 400));
		add(puzzleFlag, BorderLayout.CENTER);
	}

	private void addCountryList() {
		countryList = new JList<>();
		countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		countryList.setPreferredSize(new Dimension(150, 200));
		add(countryList, BorderLayout.LINE_END);
	}

	private void addGuessButton() {
		guessButton = new JButton(NEXT_PUZZLE);
		guessButton.setEnabled(false);
		add(guessButton, BorderLayout.PAGE_END);
	}

	public void clearLastGame() {
		puzzleFlag.setIcon(null);
		guessButton.removeActionListener(generateListener);
		guessButton.removeActionListener(guessListener);
	}

	public void prepareNextPuzzle() {
		guessButton.setText(NEXT_PUZZLE);
		guessButton.removeActionListener(guessListener);
		guessButton.addActionListener(generateListener);
		guessButton.setEnabled(true);
	}

	public void updateCountries(List<Country> countries) {
		DefaultListModel<Country> listModel = new DefaultListModel<>();
		countryList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				guessButton.setEnabled(!countryList.isSelectionEmpty());
			}
		});
		countries.forEach(listModel::addElement);
		countryList.setModel(listModel);
	}

	public void puzzleGenerated() {
		setNewPuzzleFlag();
		guessButton.setText(GUESS);
		countryList.clearSelection();
		guessButton.setEnabled(false);
		guessButton.removeActionListener(generateListener);
		guessButton.addActionListener(guessListener);
	}

	private void setNewPuzzleFlag() {
		Image original = new ImageIcon(engine.getPuzzleFile()).getImage();
		ImageIcon resized = new ImageIcon(original.getScaledInstance(600, 400, Image.SCALE_DEFAULT));
		puzzleFlag.setIcon(resized);
	}

	public JLabel getPuzzleFlag() {
		return puzzleFlag;
	}

	public JList<Country> getCountryList() {
		return countryList;
	}

	public JButton getGuessButton() {
		return guessButton;
	}

}
