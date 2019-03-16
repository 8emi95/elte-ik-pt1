package nk_gy9_sudoku.gui;

import javax.swing.JButton;

/**
 * Saj�t gomb oszt�ly, amely 2 indexet v�r param�terben, mellyel �sszek�thet�, hogy a fel�leten a GridLayout-ba tett gomb,
 * hol tal�lhat� meg a j�t�k logik�ban tal�lhat� m�trixban.
 */
public class SudokuButton extends JButton{

    private final int positionX;
    private final int positionY;

    public SudokuButton(final int positionX, final int positionY){
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
