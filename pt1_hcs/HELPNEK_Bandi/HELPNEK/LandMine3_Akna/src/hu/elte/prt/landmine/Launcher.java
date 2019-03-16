package hu.elte.prt.landmine;

import hu.elte.prt.landmine.model.LandMineEngine;
import hu.elte.prt.landmine.view.LandMineFrame;

public class Launcher {

    public static void main(String args[]) {
	LandMineEngine engine = new LandMineEngine();
	LandMineFrame frame = new LandMineFrame(engine);
	engine.setListener(frame);
	engine.startNewGame();
	frame.showFrame();
    }

}
