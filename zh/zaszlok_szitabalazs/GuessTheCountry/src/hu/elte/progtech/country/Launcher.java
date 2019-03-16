package hu.elte.progtech.country;

import javax.swing.JFrame;

import hu.elte.progtech.country.model.CountryEngine;
import hu.elte.progtech.country.view.CountryFrame;

public class Launcher {

	public static void main(String[] args) {
		CountryEngine engine = new CountryEngine();
		CountryFrame frame = new CountryFrame(engine);
		engine.setView(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
