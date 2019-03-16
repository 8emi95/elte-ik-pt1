package controller;

import java.awt.Color;

import model.KnightModel;

public class KnightController {
	private KnightModel model = new KnightModel();

	public void initTable(int size) {
		model.initTable(size);
	}

	public void initStep() {
		model.initSteps();
	}

	public void step(int i, int j) {
		model.step(i, j);
	}

	public boolean isFinishedGame() {
		return model.isFinished();
	}

	public int getSize() {
		return model.getSize();
	}

	public String getSteps() {
		return Integer.toString(model.getSteps());
	}

	public Color getColor(int i, int j) {
		return model.getColor(i, j);
	}

	public int getKnightX() {
		return model.getKnightX();
	}

	public int getKnightY() {
		return model.getKnightY();
	}

	public Color getDisturbedColor() {
		return model.getDisturbedColor();
	}
}
