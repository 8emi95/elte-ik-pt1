package hu.elte.prt.numbers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class NumbersField extends JButton {

    private static final long serialVersionUID = 8619250999139328152L;

    private int row;
    private int column;

    public NumbersField(int row, int column) {
	this.row = row;
	this.column = column;
	setBackground(Color.LIGHT_GRAY);
	setForeground(Color.GRAY);
	setPreferredSize(new Dimension(80, 80));
	setFont(getFont().deriveFont(Font.BOLD, 20));
    }

    public int getRow() {
	return row;
    }

    public int getColumn() {
	return column;
    }

}
