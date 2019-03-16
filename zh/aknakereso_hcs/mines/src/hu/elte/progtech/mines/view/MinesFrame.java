package hu.elte.progtech.mines.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.WHITE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import hu.elte.progtech.mines.model.MinesEngine;

public class MinesFrame extends JFrame {
	private static final String PLAYER_SYMBOL = "X";
	private static final int FIELD_SIZE = 65;
	private static final long serialVersionUID = 1L;
	private MinesEngine engine;

	public MinesFrame(MinesEngine engine) {
		super("progtech Mines zh");
		this.engine = engine;
	}

	public void showFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		addFields();

		setVisible(true);
		pack();
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
				addField(i, j);
			}
		}
	}

	private void addField(int row, int column) {
		JButton field = createField(row, column);
		getContentPane().add(field);
	}

	private JButton createField(int row, int column) {
		JButton field = new JButton();
		if (engine.isPlayersPosition(row, column)) {
			field.setText(PLAYER_SYMBOL);
		}
		field.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
		field.setFont(field.getFont().deriveFont(20.0f));
		field.setBackground(getBackgroundColor(row, column));
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				engine.moveTo(row, column);
				updateFields();
			}
		});
		return field;
	}

	protected void updateFields() {
		for (int i = 0; i < engine.getSize(); i++) {
			for (int j = 0; j < engine.getSize(); j++) {
				updateField(i, j);
			}
		}
	}

	private void updateField(int row, int column) {
		JButton field = (JButton) getContentPane().getComponent(row * engine.getSize() + column);
		field.setText(getFieldText(row, column));
		field.setBackground(getBackgroundColor(row, column));
	}

	private String getFieldText(int row, int column) {
		return engine.isPlayersPosition(row, column) ? PLAYER_SYMBOL : "";
	}

	private Color getBackgroundColor(int row, int column) {
		if (engine.isPaused()){
			return GRAY;
		}
		return engine.isInPath(row, column) ? GREEN : WHITE;
	}

}
