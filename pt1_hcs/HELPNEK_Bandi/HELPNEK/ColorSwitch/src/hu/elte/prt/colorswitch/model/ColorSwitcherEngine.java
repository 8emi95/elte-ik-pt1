package hu.elte.prt.colorswitch.model;

import java.util.Random;

import hu.elte.prt.colorswitch.model.domain.FieldColor;

public class ColorSwitcherEngine {

    private ColorSwitcherGUI gui;
    private FieldColor colors[][];
    private int clickCount;
    private Random generator = new Random(System.currentTimeMillis());

    public ColorSwitcherEngine() {
	newGame();
    }

    public void setGUI(ColorSwitcherGUI gui) {
	this.gui = gui;
    }

    public int getSize() {
	return 4;
    }

    public void newGame() {
	clickCount = 0;
	setColorsArray();
	if (null != gui) {
	    gui.update();
	}
    }

    private void setColorsArray() {
	colors = new FieldColor[getSize()][getSize()];
	for (int i = 0; i < getSize(); ++i) {
	    for (int j = 0; j < getSize(); ++j) {
		colors[i][j] = getNextRandomColor();
	    }
	}
    }

    private FieldColor getNextRandomColor() {
	// return FieldColor.BLUE; //to test victory conditions
	return FieldColor.values()[generator.nextInt(FieldColor.values().length)];
    }

    public FieldColor getColorOfField(int row, int column) {
	return colors[row][column];
    }

    public void clicked(int i, int j) {
	for (int k = 0; k < getSize(); ++k) {
	    if (colorByRows()) {
		colors[i][k] = colors[i][k].succ();
	    } else {
		colors[k][j] = colors[k][j].succ();
	    }
	}
	++clickCount;
	gui.update();
	if (won()) {
	    gui.won(clickCount);
	}
    }

    public boolean colorByRows() {
	return clickCount % 2 < 1;
    }

    private boolean won() {
	FieldColor c = colors[0][0];
	for (int i = 0; i < getSize(); ++i) {
	    for (int j = 0; j < getSize(); ++j) {
		if (colors[i][j] != c) {
		    return false;
		}
	    }
	}
	return true;
    }

}
