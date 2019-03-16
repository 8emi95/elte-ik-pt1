package hu.elte.prt.numbers.model;

import java.util.Random;
import java.util.TimerTask;

public class NumberGeneratorTask extends TimerTask {

    private Random generator = new Random(System.currentTimeMillis());
    private NumbersEngine engine;

    public NumberGeneratorTask(NumbersEngine engine) {
	this.engine = engine;
    }

    @Override
    public void run() {
	checkEndGame();
	generateNewNumber();
    }

    private void checkEndGame() {
	if (engine.isFull()) {
	    engine.lost();
	}
    }

    private void generateNewNumber() {
	boolean completed = false;
	while (!completed) {
	    int row = generator.nextInt(engine.getSize());
	    int column = generator.nextInt(engine.getSize());
	    if (0 == engine.getValue(row, column)) {
		int value = generator.nextInt(engine.getSize()) + 1;
		engine.setValue(row, column, value);
		completed = true;
	    }
	}
    }

}
