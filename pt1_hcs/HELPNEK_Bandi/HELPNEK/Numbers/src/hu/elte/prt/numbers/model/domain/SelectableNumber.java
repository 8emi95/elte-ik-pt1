package hu.elte.prt.numbers.model.domain;

public class SelectableNumber {

    private int value;
    private boolean selected;

    public SelectableNumber() {
	value = 0;
	selected = false;
    }

    public int getValue() {
	return value;
    }

    public void setValue(int value) {
	this.value = value;
	this.selected = false;
    }

    public boolean isSelected() {
	return selected;
    }

    public void select() {
	selected = true;
    }

    public void deselect() {
	selected = false;
    }

}
