package hu.valdar.progtech.gy9.sudoku;

import hu.valdar.progtech.gy9.sudoku.gui.SudokuFrame;
import hu.valdar.progtech.gy9.sudoku.model.SudokuLogic;

public class Boot {

    public static void main(String[] args) {
        /*
         * Egy swinget használó program, minimum két szálat használ:
         * 1. indító szál (például: a main), 2. esemény szál (pl.: a swing komponensek kezelése / események kezelése)
         * A Swing komponenseinek legtöbb metódusa nem szál biztos, azaz nincs felkészítve a konkurens hozzáférés lehetőségére.
         * Ha nem az eseményszálból hívjuk meg ezeket, akkor hiba történhet!
         *
         * Az indító szálban nem szabad létrehozni/ kezelni swing komponenseket, ezért a GUI-val kapcsolatos funkciókat a
         * java.awt.EventQueue vagy a javax.swing.SwingUtilities invokeLater() (vagy az invokeAndWait()) metódusának segítségével az eseményszálban hajtjuk végre.
         *
         * (Megjegyzés: szálakról lesz szó később.)
         */
        java.awt.EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new SudokuFrame(new SudokuLogic()).setVisible(true);
            }
        
        });
    }
    
}
