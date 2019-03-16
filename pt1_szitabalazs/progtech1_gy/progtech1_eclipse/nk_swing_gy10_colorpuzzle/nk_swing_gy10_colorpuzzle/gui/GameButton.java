package nk_swing_gy10_colorpuzzle.gui;

import javax.swing.JButton;

/**
 * Saj�t gomb oszt�ly, amely 2 indexet v�r param�terben, mellyel �sszek�thet�, hogy a fel�leten a GridLayout-ba tett gomb,
 * hol tal�lhat� meg a j�t�k logik�ban tal�lhat� m�trixban.
 * @author Nagy Kriszti�n
 */
public class GameButton extends JButton{
    private final int row;
    private final int column;
    
    public GameButton(final int row, final int column){
        this.row = row;
        this.column = column;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getColumn(){
        return column;
    }    
}
