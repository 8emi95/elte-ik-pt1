package hu.elte.progtech.sudoku.view;

import javax.swing.JLabel;

public class SizeLabel extends JLabel {

	private static final long serialVersionUID = 1453377149357392394L;

	int size;

	public SizeLabel(int size) {
		super(getLabelText(size));
		this.size = size;
	}

	private static String getLabelText(int size) {
		return size + "×" + size;
	}

	public int getBoardSize() {
		return size;
	}

	@Override
	public String toString() { //Note: JOptionPane will show this as label
		return getText();
	}

}
