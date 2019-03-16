package hu.rekakosa.progtech.game.view;

import javax.swing.*;

public class GameButton extends JButton {

    private final int positionX;
    private final int positionY;

    public GameButton(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
