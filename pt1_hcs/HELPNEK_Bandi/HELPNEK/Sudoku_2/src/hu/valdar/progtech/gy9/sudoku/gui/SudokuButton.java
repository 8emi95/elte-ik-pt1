package hu.valdar.progtech.gy9.sudoku.gui;

import javax.swing.JButton;

/**
 * A javax.swing.JButton osztályból specializált gombot megvalosító típus, mely
 * a grafikus felületű Sodoku táblán 1-1 mezőként jelenik meg.
 * @author Nagy Krisztián
 */
public class SudokuButton extends JButton{

    private final int positionX;
    private final int positionY;
    
    /**
     * Két paraméteres konstruktor, melynek segítségével beállíthatjuk, hogy az 
     * aktuális gomb milyen pozíción helyezkedik el a Sodoku táblában.
     * A táblát a logika alapján egy mátrixként ábrázoljuk. A két paraméter így
     * a sor és az oszlop indexet hivatott meghatározni.
     * @param positionX a gomb egy adott sorban található pozíciója
     * @param positionY a gomb egy adott oszlopban található pozíciója
     */
    public SudokuButton(final int positionX, final int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * Getter metódus, mely segítségével elkérhetjük az aktuális gomb sorbeli
     * elhelyezkedését.
     * @return a sorbeli elhelyezkedésének az indexe
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Getter metódus, mely segítségével elkérhetjük az aktuális gomb oszlopbeli
     * elhelyezkedését.
     * @return az oszlopbeli elhelyezkedés indexe
     */
    public int getPositionY() {
        return positionY;
    }
    
}
