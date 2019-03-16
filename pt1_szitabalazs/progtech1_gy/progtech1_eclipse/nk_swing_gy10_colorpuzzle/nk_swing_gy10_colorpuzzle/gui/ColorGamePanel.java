package nk_swing_gy10_colorpuzzle.gui;

import nk_swing_gy10_colorpuzzle.logic.ColorGameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Nagy Krisztián
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
     * Játéktér létrehozása.
     */
    private void setupGamePanel() {
        // Kitöröljük a panelunkon található összes komponenst. (Új játék esetén hasznos :))
        removeAll();
        // Elkérjük a játéktér méretét
        int n = logic.getSize();
        // Létrehozzuk a játéktérnek megfelelõen a grideket.
        setLayout(new GridLayout(n, n));
        for (int row = 0; row < n; ++row) {
            for (int column = 0; column < n; ++column) {
                // Minden egyes gridbe egy 40x40-es méretû gombot teszünk, melyhez hozzáadjuk a szükséges eseménykezelõnket.
                final JButton btn = new GameButton(row, column);
                btn.setPreferredSize(new Dimension(40, 40));
                btn.addActionListener(gameButtonActionListener);
                add(btn);
            }
        }
    }

    /**
     * Játéktér frissítése.
     */
    private void refreshUI(){
        // Végigmegyünk az összes komponensen, ami a játéktért megvalósító panelon található. (Ezek a gombjaink lesznek)
        for(Component component : getComponents()){
            GameButton btn = (GameButton) component;
            int row = btn.getRow();
            int column = btn.getColumn();
            // Elkérjük, hogy az adott pozíción a logika szerint milyen érték található
            int fieldValue = logic.getFieldValue(row, column);
            // Az értéknek megfelelõen beszínezzük a gombunkat.
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
     * Gomb lenyomását figyelõ eseménykezelõ.
     */
    private class GameButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            /* Elkérjük a kiváltódott esemény forrássát. Mivel csak a saját gombjaink találhatóak meg a táblánkon, ezért
             * eltekinthetünk az instanceof vizsgálattól.
             */
            GameButton gameButton = (GameButton) e.getSource();
            int row = gameButton.getRow();
            int column = gameButton.getColumn();
            // A logikát meghívva megváltozatjuk a mezõk értékét, a kattintott gombban eltárolt pozíciók segítségével.
            logic.changeFieldValues(row, column);
            // Frissítjük az információs panelen a felhasználó lépéseinek a számát.
            infoPanel.setSteps(logic.getSteps());
            // Frissítjük a játéktéren található gombokat
            refreshUI();
            // Ellenõrizzük, hogy véget ért-e a játék.
            checkForEndGame();
            
        }
        
    }

    /**
     * Megnézzük, hogy nyert-e a játékos. Amennyiben igen, úgy egy felugró ablak segítségével gratulálunk neki.
     */
    private void checkForEndGame(){
        if(logic.isGameEnd()){
            JOptionPane.showMessageDialog(null, "Congratulation! You won the game!", "Grats", JOptionPane.INFORMATION_MESSAGE);
        }
    }    
}
