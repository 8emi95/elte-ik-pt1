package controller;

import model.ColorModel;

public class QueenController {
	private ColorModel model = new ColorModel();

	public void initTable(int size) {
		model.initTable(size);
	}

	public int getSize() {
		return model.getSize();
	}

	public java.awt.Color getColor(int i, int j) {
		String c = model.getColor(i, j);

		return transformColor(c);
	}

	private java.awt.Color transformColor(String c) {
		if ("red".equals(c)) {
			return java.awt.Color.RED;
		} else if ("blue".equals(c)) {
			return java.awt.Color.BLUE;
		} else if ("green".equals(c)) {
			return java.awt.Color.GREEN;
		} else {
			return java.awt.Color.YELLOW;
		}
	}

	public java.awt.Color nextColor(java.awt.Color color) {
		String c;

		if (java.awt.Color.RED.equals(color)) {
			c = "red";
		} else if (java.awt.Color.BLUE.equals(color)) {
			c = "blue";
		} else if (java.awt.Color.GREEN.equals(color)) {
			c = "green";
		} else {
			c = "yellow";
		}

		c = model.next(c);
		return transformColor(c);
	}

	public boolean isFinishedGame() {
		return model.isFinished();
	}

	public void increaseSteps() {
		model.increaseStep();
	}

	public void initStep() {
		model.initStep();
	}

	public String getSteps() {
		return Integer.toString(model.getSteps());
	}

}
