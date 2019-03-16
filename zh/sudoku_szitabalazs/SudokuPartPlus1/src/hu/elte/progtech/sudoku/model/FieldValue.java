package hu.elte.progtech.sudoku.model;

public class FieldValue {

	private int value;
	private boolean predefined;

	public FieldValue(int value, boolean predefined) {
		this.value = value;
		this.predefined = predefined;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isPredefined() {
		return predefined;
	}

	public void incrementValue() {
		++value;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof FieldValue) {
			FieldValue other = (FieldValue) o;
			return other.value == value;
		}
		return false;
	}

	public int hashCode() {
		return value;
	}

}
