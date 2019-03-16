package model;

import java.util.Random;

public class ColorModel {
	private Random rnd = new Random();
	private String[][] gameTable;
	private int size;
	private int steps;

	public void initTable(int size) {
		this.size = size;
		initGameTable();
	}

	private void initGameTable() {
		gameTable = new String[size][size];

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				gameTable[i][j] = getRandomColor();
			}
		}
	}

	private String getRandomColor() {
		int random = rnd.nextInt(4);
		
		switch (random) {
			case 0: return "blue";
			case 1: return "green";
			case 2: return "red";
			default:return "yellow";
		}
	}
	
	public String next(String color) {
		if ("blue".equals(color)) {
			return "green";
		} else if ("green".equals(color)) {
			return "red";
		} else if ("red".equals(color)) {
			return "yellow";
		}
		return "blue";
	}

	public int getSize() {
		return size;
	}

	public String getColor(int i, int j) {
		return gameTable[i][j];
	}

	public boolean isFinished() {
		String c = gameTable[0][0];

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (!c.equals(gameTable[i][j])) {
					return false;
				}
			}
		}

		return true;
	}

	public void increaseStep() {
		steps++;
	}

	public int getSteps() {
		return steps;
	}

	public void initStep() {
		steps = 0;
	}

}
