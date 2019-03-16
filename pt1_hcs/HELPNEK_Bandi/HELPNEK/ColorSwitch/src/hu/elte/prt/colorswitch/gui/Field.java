package hu.elte.prt.colorswitch.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

import hu.elte.prt.colorswitch.model.domain.FieldColor;

public class Field extends JButton {

    private static final long serialVersionUID = -2524418379422997555L;

    private int row;
    private int column;

    public Field(int row, int column, FieldColor color) {
	this.row = row;
	this.column = column;
	setPreferredSize(new Dimension(100, 100));
	setColor(color);
    }

    public void setColor(FieldColor color) {
	setBackground(getColorOfField(color));
    }

    private Color getColorOfField(FieldColor color) {
	switch (color) {
	case RED:
	    return Color.RED;
	case YELLOW:
	    return Color.YELLOW;
	case BLUE:
	    return Color.BLUE;
	default:
	    return null;
	}
    }

    public int getRow() {
	return row;
    }

    public int getColumn() {
	return column;
    }

}
