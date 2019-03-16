package hu.elte.progtech.sudoku.model.field;

public abstract class ValueInitializer {

	private int size;
	protected FieldValue values[][];

	public ValueInitializer(int size, FieldValue values[][]) {
		this.size = size;
		this.values = values;
	}

	public void initializeValues() {
		setPredefinedValues();
		setOtherValues();
	}

	protected abstract void setPredefinedValues();

	private void setOtherValues() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (values[i][j] == null) {
					values[i][j] = new FieldValue(0, false);
				}
			}
		}
	}

}
