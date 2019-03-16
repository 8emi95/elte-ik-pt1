package hu.elte.progtech.country.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import hu.elte.progtech.country.model.Country;
import hu.elte.progtech.country.model.CountryEngine;

public class GuessActionListener implements ActionListener {

	private CountryEngine engine;
	private JList<Country> countryList;

	public GuessActionListener(JList<Country> countryList, CountryEngine engine) {
		this.countryList = countryList;
		this.engine = engine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		engine.guess(countryList.getSelectedValue());
	}
}