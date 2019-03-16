package hu.elte.progtech.dama.view;

import static hu.elte.progtech.dama.model.CheckersEngine.SIZE;
import static java.awt.Color.GRAY;
import static java.awt.Color.LIGHT_GRAY;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import hu.elte.progtech.dama.model.CheckersEngine;

public class CheckersFrame extends JFrame {

	private static final long serialVersionUID = 6878777690853630717L;

	private CheckersEngine engine;

	public CheckersFrame(CheckersEngine engine) {
		this.engine = engine;
		setResizable(false);
		setLayout(new GridLayout(SIZE, SIZE));
		createFields();
		pack();
	}

	private void createFields() {
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.setBackground(getBackground(i, j));
				button.setForeground(getColor(i, j));
				button.setText(getValue(i, j));
				getContentPane().add(button);
			}
		}
	}

	private Color getColor(int i, int j) {
		switch (engine.getValue(i, j)) {
		case RED:
			return Color.RED;
		case WHITE:
			return Color.WHITE;
		default:
			return Color.BLACK;
		}
	}

	private String getValue(int i, int j) {
		switch (engine.getValue(i, j)) {
		case RED:
			return "●";
		case WHITE:
			return "●";
		default:
			return "";
		}
	}

	private Color getBackground(int i, int j) {
		if ((i + j) % 2 == 0) {
			return LIGHT_GRAY;
		} else {
			return GRAY;
		}
	}

}
