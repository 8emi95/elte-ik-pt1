package nk_swing_gy10_colorpuzzle.gui;

import javax.swing.JButton;

/**
 * Saját gomb osztály, amely 2 indexet vár paraméterben, mellyel összeköthetõ, hogy a felületen a GridLayout-ba tett gomb,
 * hol található meg a játék logikában található mátrixban.
 * @author Nagy Krisztián
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
