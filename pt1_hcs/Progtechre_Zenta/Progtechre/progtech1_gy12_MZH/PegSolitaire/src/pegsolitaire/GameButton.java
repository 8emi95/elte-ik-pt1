package pegsolitaire;

import javax.swing.JButton;

class GameButton extends JButton {

    private final int posX, posY;

    public GameButton(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    
    
}
