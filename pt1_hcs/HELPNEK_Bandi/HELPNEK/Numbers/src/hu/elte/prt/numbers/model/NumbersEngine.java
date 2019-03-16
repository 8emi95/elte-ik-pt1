package hu.elte.prt.numbers.model;

import java.util.Timer;

import hu.elte.prt.numbers.model.domain.SelectableNumber;

public class NumbersEngine {

    private NumbersGUI gui;
    private int size;
    private SelectableNumber[][] numbers;
    private Integer selectedValue;
    private Timer timer;

    public void setGUI(NumbersGUI gui) {
	this.gui = gui;
    }

    public int getSize() {
	return size;
    }

    public void newGame(int size) {
	this.size = size;
	this.numbers = new SelectableNumber[size][size];
	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		numbers[i][j] = new SelectableNumber();
	    }
	}
	this.selectedValue = null;
	setTimer();
	gui.newGame();
    }

    private void setTimer() {
	clearTimer();
	timer = new Timer();
	timer.schedule(new NumberGeneratorTask(this), 1000, 1000);
    }

    private void clearTimer() {
	if (null != timer) {
	    timer.cancel();
	    timer.purge();
	}
    }

    public int getValue(int row, int column) {
	return numbers[row][column].getValue();
    }

    public void setValue(int row, int column, int value) {
	numbers[row][column].setValue(value);
	gui.updateGame();

    }

    public void select(int i, int j) {
	SelectableNumber selected = numbers[i][j];
	if (misselected(selected)) {
	    clearSelection();
	}
	numbers[i][j].select();
	selectedValue = selected.getValue();
	if (selectedAreEnough()) {
	    removeSelected();
	}
	gui.updateGame();
    }

    private boolean misselected(SelectableNumber selected) {
	return selected.isSelected() || 0 == selected.getValue()
		|| (null != selectedValue && selectedValue != selected.getValue());
    }

    private boolean selectedAreEnough() {
	int countOfSelected = 0;
	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		if (numbers[i][j].isSelected()) {
		    ++countOfSelected;
		}
	    }
	}
	return countOfSelected >= selectedValue;
    }

    private void removeSelected() {
	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		if (numbers[i][j].isSelected()) {
		    numbers[i][j].setValue(0);
		}
	    }
	}
	selectedValue = null;
    }

    private void clearSelection() {
	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		numbers[i][j].deselect();
	    }
	}
    }

    public boolean isSelected(int row, int column) {
	return numbers[row][column].isSelected();
    }

    public boolean isFull() {
	return size * size <= getNumbersCount();
    }

    private int getNumbersCount() {
	int count = 0;
	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		if (numbers[i][j].getValue() != 0) {
		    ++count;
		}
	    }
	}
	return count;
    }

    public void lost() {
	gui.lost();
    }

}
