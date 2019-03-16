package hu.elte.progtech.country.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hu.elte.progtech.country.model.CountryEngine;

public class GeneratePuzzleActionListener implements ActionListener {

	private final CountryEngine engine;

	GeneratePuzzleActionListener(CountryEngine engine) {
		this.engine = engine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		engine.generatePuzzle();
	}
}