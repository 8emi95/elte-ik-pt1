package sudoku;

import sudoku.gui.SudokuFrame;
import sudoku.logic.SudokuLogic;

/**
 * Az alkalmazásunk indításáért felelős osztály, amely tartalmazza a főprogramot.
 */
public class Boot {

    public static void main(String[] args) {
        /*
         * Grafikus alkalmazások esetén fontos arra figyelnünk, hogy a GUI-val kapcsolatos eseményeket és műveleteket az
         * Event Dispatcher Thread-en (EDT)-n kezeljük, mivel egy a háttérben futó komolyabb számításnak nem szabad megbénítania
         * a felhasználói interakciót a felülettel.
         *
         * Jelen esetben a háttér szálunk maga a főprogram (main) lesz.
         * Magának a Swing-nek is van metódusa az Event Dispatcher Thread-hez (javax.swing.SwingUtilities.invokeLater(..)),
         * de ez lényegében az awt-s változatot hívja, ezért nem lényeges, hogy a kettő közül melyiket használjuk.
         *
         */
        java.awt.EventQueue.invokeLater(() ->
                {
                    // Létrehozunk a saját keretünket és láthatóvá tesszük
                    new SudokuFrame(new SudokuLogic()).setVisible(true);
                }
        );

        /*
         * Névtelen osztályt használtunk, amely megvalósítja a Runnable interfészt.
         *
         * Java 7 ben:
         * java.awt.EventQueue.invokeLater(
         *      new Runnable(){
         *          @Override
         *          public void run(){
         *              new SudokuFrame(new SudokuLogic()).setVisible(true);
         *          }
         *      }
         * );
         */
    }

}
