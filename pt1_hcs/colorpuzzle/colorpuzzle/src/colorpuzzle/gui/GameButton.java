package colorpuzzle.gui;

import javax.swing.JButton;

/**
 * Saját gomb osztály, amely 2 indexet vár paraméterben, mellyel összeköthető, hogy a felületen a GridLayout-ba tett gomb,
 * hol található meg a játék logikában található mátrixban.
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
