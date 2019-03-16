package hu.rekakosa.progtech.game;

import hu.rekakosa.progtech.game.view.GameFrame;
import hu.rekakosa.progtech.game.logic.GameLogic;

public class Boot {

    public static void main(String[] args){
        GameFrame gameFrame = new GameFrame(new GameLogic());
        gameFrame.setVisible(true);
    }
}
