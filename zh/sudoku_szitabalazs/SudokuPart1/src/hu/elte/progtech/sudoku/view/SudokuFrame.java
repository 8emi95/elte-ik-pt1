package hu.elte.progtech.sudoku.view;

import static java.awt.Color.GRAY;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import hu.elte.progtech.sudoku.model.SudokuEngine;
import hu.elte.progtech.sudoku.model.SudokuView;

public class SudokuFrame extends JFrame implements SudokuView {

	private static final long serialVersionUID = -5787540942793940226L;

	private static final String EMPTY = "";

	private SudokuEngine engine;

	public void setModel(SudokuEngine engine) {
		this.engine = engine;
	}

	public void showFrame() {
		setTitle("Sudoku");
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

	private void addField(int row, int column) {
		JButton field = new JButton(getLabelOfField(row, column));
		setBordersOfField(row, column, field);
		field.setPreferredSize(new Dimension(40, 40));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.changeValue(row, column);
			}
		});
		getContentPane().add(field);
	}

	private String getLabelOfField(int row, int column) {
		return getValueLabel(engine.getValue(row, column));
	}

	private String getValueLabel(int value) {
		return value == 0 ? EMPTY : Integer.toString(value);
	}

	private void setBordersOfField(int row, int column, JButton field) {
		int topBorder = row % engine.getBlockSize() == 0 ? 4 : 1;
		int leftBorder = column % engine.getBlockSize() == 0 ? 4 : 1;
		int bottomBorder = row == engine.getSize() - 1 ? 4 : 1;
		int rightBorder = column == engine.getSize() - 1 ? 4 : 1;
		field.setBorder(BorderFactory.createMatteBorder(topBorder, leftBorder, bottomBorder, rightBorder, GRAY));
	}

	@Override
	public void update(int row, int column, int value) {
		try {
			Component comp = getContentPane().getComponent(row * engine.getSize() + column);
			JButton field = (JButton) comp;
			field.setText(getValueLabel(value));
		} catch (ArrayIndexOutOfBoundsException e) {
			// Nothing to do.
		}
	}

}
