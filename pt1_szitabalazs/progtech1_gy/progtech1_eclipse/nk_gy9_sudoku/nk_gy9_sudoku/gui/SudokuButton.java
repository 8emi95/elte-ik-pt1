package nk_gy9_sudoku.gui;

import javax.swing.JButton;

/**
 * Saját gomb osztály, amely 2 indexet vár paraméterben, mellyel összeköthetõ, hogy a felületen a GridLayout-ba tett gomb,
 * hol található meg a játék logikában található mátrixban.
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
