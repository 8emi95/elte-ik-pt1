package hu.valdar.progtech.gy9.sudoku.gui;

import hu.valdar.progtech.gy9.sudoku.model.SudokuLogic;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * A Sudoku játék táblájának a grafikus megvalósításáért felelős osztály.
 * @author Nagy Krisztián
 */
public class SudokuBoard extends JPanel{
    /**
     * A játéktábla mezőit megvalósító gombok
     */
    private final SudokuButton[][] fields;
    /**
     * A játéktáblán található blokkok
     */
    private final JPanel[][] grids;
    /**
     * Játék logika
     */
    private final SudokuLogic logic;
    
    private final SudokuFrame sodokuFrame;
    
    public SudokuBoard(final SudokuLogic logic, final SudokuFrame sodokuFrame){
        super(new GridLayout(3,3)); // táblázatos elrendezést szeretnénk a játéktáblának, így a GridLayout-ot válasszuk.
        this.logic = logic;
        this.sodokuFrame = sodokuFrame;
        
        grids = new JPanel[3][3];
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 3; ++x) {
                grids[y][x] = new JPanel(new GridLayout(3, 3)); // Minden blokkunk 3x3-as lesz 
                grids[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // Sötét szürke színű szegéllyel
                add(grids[y][x]); 
            }
        }
        
        fields = new SudokuButton[9][9];
        for(int y = 0; y < 9; ++y){
            for(int x = 0; x < 9; ++x){
                fields[y][x] = new SudokuButton(x,y); // inicializáljuk a mezőkön található gombokat
                fields[y][x].addActionListener(onClickAction); // Minden gombhoz hozzárendeljük az akciókat
                grids[y / 3][x / 3].add(fields[y][x]); // a megfelelő blokkhoz, hozzáadjuk a gombot
            }
        }
        
    }
    
    /**
     *  Akció, amely egy gomb lenyomásakor hajtódik végre
     */
    private final Action onClickAction = new AbstractAction(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            /*
                Mivel csak a táblán található azonos típusú gombokhoz adtuk hozzá ezt az 
                action-t, így eltekinthetünk az instanceof vizsgálattól, különben
                előfordulhat, hogy nem tudjuk kasztolni a source-t.
            */
            SudokuButton btn = (SudokuButton) ae.getSource();
            final int posX = btn.getPositionX();
            final int posY = btn.getPositionY();
            
            logic.setFieldValue(posX, posY);
            final int value = logic.getFieldValue(posX, posY);
            btn.setText((value == 0) ? " " : String.valueOf(value)); // A 0 az üres mezőt jeleni
            
            if(logic.checkEndGame()){ // Amennyiben megfejtette a rejtvényt
                sodokuFrame.showMessageDialog(); // Jelezzük egy felugró ablakkal
            }
        }
        
    };    
}
