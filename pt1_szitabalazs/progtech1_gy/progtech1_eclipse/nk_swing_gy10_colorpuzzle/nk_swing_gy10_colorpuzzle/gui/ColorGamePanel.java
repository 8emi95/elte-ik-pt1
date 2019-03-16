package nk_swing_gy10_colorpuzzle.gui;

import nk_swing_gy10_colorpuzzle.logic.ColorGameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Nagy Kriszti�n
 */
public class ColorGamePanel extends JPanel {

    private final ColorGameLogic logic;
    private final ActionListener gameButtonActionListener = new GameButtonActionListener();
    private final InformationPanel infoPanel;
    
    public ColorGamePanel(final ColorGameLogic logic, final InformationPanel infoPanel){
        this.logic = logic;
        this.infoPanel = infoPanel;
        newGame();
    }

    /**
     * J�t�kt�r l�trehoz�sa.
     */
    private void setupGamePanel() {
        // Kit�r�lj�k a panelunkon tal�lhat� �sszes komponenst. (�j j�t�k eset�n hasznos :))
        removeAll();
        // Elk�rj�k a j�t�kt�r m�ret�t
        int n = logic.getSize();
        // L�trehozzuk a j�t�kt�rnek megfelel�en a grideket.
        setLayout(new GridLayout(n, n));
        for (int row = 0; row < n; ++row) {
            for (int column = 0; column < n; ++column) {
                // Minden egyes gridbe egy 40x40-es m�ret� gombot tesz�nk, melyhez hozz�adjuk a sz�ks�ges esem�nykezel�nket.
                final JButton btn = new GameButton(row, column);
                btn.setPreferredSize(new Dimension(40, 40));
                btn.addActionListener(gameButtonActionListener);
                add(btn);
            }
        }
    }

    /**
     * J�t�kt�r friss�t�se.
     */
    private void refreshUI(){
        // V�gigmegy�nk az �sszes komponensen, ami a j�t�kt�rt megval�s�t� panelon tal�lhat�. (Ezek a gombjaink lesznek)
        for(Component component : getComponents()){
            GameButton btn = (GameButton) component;
            int row = btn.getRow();
            int column = btn.getColumn();
            // Elk�rj�k, hogy az adott poz�ci�n a logika szerint milyen �rt�k tal�lhat�
            int fieldValue = logic.getFieldValue(row, column);
            // Az �rt�knek megfelel�en besz�nezz�k a gombunkat.
            btn.setBackground(getColorByFieldValue(fieldValue));
        }        
    }    

    private Color getColorByFieldValue(int fieldValue){
        switch(fieldValue){
            case 0:
                return Color.CYAN;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.GREEN;
        }
        return Color.WHITE;
    }

    public final void newGame(){
        setupGamePanel();
        refreshUI();
    }

    /**
     * Gomb lenyom�s�t figyel� esem�nykezel�.
     */
    private class GameButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /* Elk�rj�k a kiv�lt�dott esem�ny forr�ss�t. Mivel csak a saj�t gombjaink tal�lhat�ak meg a t�bl�nkon, ez�rt
             * eltekinthet�nk az instanceof vizsg�latt�l.
             */
            GameButton gameButton = (GameButton) e.getSource();
            int row = gameButton.getRow();
            int column = gameButton.getColumn();
            // A logik�t megh�vva megv�ltozatjuk a mez�k �rt�k�t, a kattintott gombban elt�rolt poz�ci�k seg�ts�g�vel.
            logic.changeFieldValues(row, column);
            // Friss�tj�k az inform�ci�s panelen a felhaszn�l� l�p�seinek a sz�m�t.
            infoPanel.setSteps(logic.getSteps());
            // Friss�tj�k a j�t�kt�ren tal�lhat� gombokat
            refreshUI();
            // Ellen�rizz�k, hogy v�get �rt-e a j�t�k.
            checkForEndGame();
            
        }
        
    }

    /**
     * Megn�zz�k, hogy nyert-e a j�t�kos. Amennyiben igen, �gy egy felugr� ablak seg�ts�g�vel gratul�lunk neki.
     */
    private void checkForEndGame(){
        if(logic.isGameEnd()){
            JOptionPane.showMessageDialog(null, "Congratulation! You won the game!", "Grats", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
}
