package bead2;

import bead2.view.GameFrame;
import bead2.logic.GameLogic;

public class Boot {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame(new GameLogic());
        gameFrame.setVisible(true);
    }
}