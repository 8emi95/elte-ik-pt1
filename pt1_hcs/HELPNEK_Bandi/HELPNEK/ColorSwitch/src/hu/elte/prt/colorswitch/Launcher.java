package hu.elte.prt.colorswitch;

import hu.elte.prt.colorswitch.gui.ColorSwitcherFrame;
import hu.elte.prt.colorswitch.model.ColorSwitcherEngine;

public class Launcher {

    public static void main(String args[]) {
	ColorSwitcherEngine engine = new ColorSwitcherEngine();
	ColorSwitcherFrame frame = new ColorSwitcherFrame(engine);
	engine.setGUI(frame);
	frame.showFrame();
    }

}
