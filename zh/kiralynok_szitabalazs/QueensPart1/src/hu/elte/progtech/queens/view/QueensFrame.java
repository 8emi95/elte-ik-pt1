package hu.elte.progtech.queens.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import hu.elte.progtech.queens.model.QueensEngine;

public class QueensFrame extends JFrame {

	private static final String EMPTY = "";
	private static final String QUEEN = "Q";
	private static final long serialVersionUID = 2265228622194396011L;
	private QueensEngine engine;

	public QueensFrame(QueensEngine engine) {
		super("Queens");
		this.engine = engine;
	}

	public void showFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		addFields();
		setVisible(true);
		pack();
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				addField(i, j);
			}
		}
	}

	private void addField(int i, int j) {
		JButton field = new JButton();
		field.setPreferredSize(new Dimension(65, 65));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getFieldBackground(i, j));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.put(i, j);
				updateFields();
			}
		});
		getContentPane().add(field);
	}

	private Color getFieldBackground(int row, int column) {
		return row % 2 == column % 2 ? WHITE : GRAY;
	}

	private void updateFields() {
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				updateField(i, j);
			}
		}
	}

	private void updateField(int row, int column) {
		Component component = getContentPane().getComponent(row * engine.getSize() + column);
		JButton field = (JButton) component;
		field.setText(getFieldLabel(row, column));
	}

	private String getFieldLabel(int row, int column) {
		return engine.isQueen(row, column) ? QUEEN : EMPTY;
	}

}
