package hu.elte.progtech.sudoku.model.field;

public class ValueInitializer9x9 extends ValueInitializer {

	public ValueInitializer9x9(FieldValue[][] values) {
		super(9, values);
	}

	@Override
	protected void setPredefinedValues() {
		values[0][2] = new FieldValue(6, true);
		values[0][4] = new FieldValue(5, true);
		values[0][5] = new FieldValue(4, true);
		values[0][6] = new FieldValue(9, true);
		values[1][0] = new FieldValue(1, true);
		values[1][4] = new FieldValue(6, true);
		values[1][7] = new FieldValue(4, true);
		values[1][8] = new FieldValue(2, true);
		values[2][0] = new FieldValue(7, true);
		values[2][4] = new FieldValue(8, true);
		values[2][5] = new FieldValue(9, true);
		values[3][1] = new FieldValue(7, true);
		values[3][5] = new FieldValue(5, true);
		values[3][7] = new FieldValue(8, true);
		values[3][8] = new FieldValue(1, true);
		values[4][1] = new FieldValue(5, true);
		values[4][3] = new FieldValue(3, true);
		values[4][4] = new FieldValue(4, true);
		values[4][6] = new FieldValue(6, true);
		values[5][0] = new FieldValue(4, true);
		values[5][2] = new FieldValue(2, true);
		values[6][1] = new FieldValue(3, true);
		values[6][2] = new FieldValue(4, true);
		values[6][6] = new FieldValue(1, true);
		values[7][0] = new FieldValue(9, true);
		values[7][3] = new FieldValue(8, true);
		values[7][7] = new FieldValue(5, true);
		values[8][3] = new FieldValue(4, true);
		values[8][6] = new FieldValue(3, true);
		values[8][8] = new FieldValue(7, true);
	}

}
