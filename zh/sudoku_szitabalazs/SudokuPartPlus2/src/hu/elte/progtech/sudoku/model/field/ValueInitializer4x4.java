package hu.elte.progtech.sudoku.model.field;

public class ValueInitializer4x4 extends ValueInitializer {

	public ValueInitializer4x4(FieldValue[][] values) {
		super(4, values);
	}

	@Override
	protected void setPredefinedValues() {
		values[0][0] = new FieldValue(3, true);
		values[0][2] = new FieldValue(4, true);
		values[1][1] = new FieldValue(1, true);
		values[1][3] = new FieldValue(3, true);
		values[2][0] = new FieldValue(2, true);
		values[2][1] = new FieldValue(3, true);
		values[3][0] = new FieldValue(1, true);
		values[3][3] = new FieldValue(2, true);
	}

}
