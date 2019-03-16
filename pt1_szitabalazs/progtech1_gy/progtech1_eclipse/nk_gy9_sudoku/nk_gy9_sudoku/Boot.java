package nk_gy9_sudoku;

import nk_gy9_sudoku.gui.SudokuFrame;
import nk_gy9_sudoku.logic.SudokuLogic;

/**
 * Az alkalmaz�sunk ind�t�s��rt felel�s oszt�ly, amely tartalmazza a f�programot.
 */
public class Boot {

    public static void main(String[] args) {
        /*
         * Grafikus alkalmaz�sok eset�n fontos arra figyeln�nk, hogy a GUI-val kapcsolatos esem�nyeket �s m�veleteket az
         * Event Dispatcher Thread-en (EDT)-n kezelj�k, mivel egy a h�tt�rben fut� komolyabb sz�m�t�snak nem szabad megb�n�tania
         * a felhaszn�l�i interakci�t a fel�lettel.
         *
         * Jelen esetben a h�tt�r sz�lunk maga a f�program (main) lesz.
         * Mag�nak a Swing-nek is van met�dusa az Event Dispatcher Thread-hez (javax.swing.SwingUtilities.invokeLater(..)),
         * de ez l�nyeg�ben az awt-s v�ltozatot h�vja, ez�rt nem l�nyeges, hogy a kett� k�z�l melyiket haszn�ljuk.
         *
         */
        java.awt.EventQueue.invokeLater(() ->
                {
                    // L�trehozunk a saj�t keret�nket �s l�that�v� tessz�k
                    new SudokuFrame(new SudokuLogic()).setVisible(true);
                }
        );

        /*
         * N�vtelen oszt�lyt haszn�ltunk, amely megval�s�tja a Runnable interf�szt.
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
