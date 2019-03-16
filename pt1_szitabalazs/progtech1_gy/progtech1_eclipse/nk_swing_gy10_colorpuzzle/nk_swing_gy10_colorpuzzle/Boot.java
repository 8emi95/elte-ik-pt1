package nk_swing_gy10_colorpuzzle;

import nk_swing_gy10_colorpuzzle.gui.ColorGameFrame;
import nk_swing_gy10_colorpuzzle.logic.ColorGameLogic;

public class Boot {

    public static void main(String[] args){
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
        java.awt.EventQueue.invokeLater(
                () -> new ColorGameFrame(new ColorGameLogic()).setVisible(true)
        );
        /*
         * N�vtelen oszt�lyt haszn�ltunk, amely megval�s�tja a Runnable interf�szt.
         *
         * Java 7 ben:
         * java.awt.EventQueue.invokeLater(
         *      new Runnable(){
         *          @Override
         *          public void run(){
         *              new ColorGameFrame(new ColorGameLogic()).setVisible(true);
         *          }
         *      }
         * );
         */
    }

}
