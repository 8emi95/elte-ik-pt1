package nk_swing_gy10_colorpuzzle.gui;

import nk_swing_gy10_colorpuzzle.logic.ColorGameLogic;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 * @author Nagy Kriszti�n
 */
public class ColorGameFrame extends JFrame {

    private final ColorGameLogic colorGameLogic;
    private final ColorGamePanel gamePanel;
    private final JMenuBar menuBar;
    private final InformationPanel infoPanel;
    
    public ColorGameFrame(final ColorGameLogic colorGameLogic) {
        this.colorGameLogic = colorGameLogic;
        setFrameProperties();
        applyNimbusLookAndFeelTheme();
        // Kezdetben 10x10-es j�t�kt�bl�t hozunk l�tre.
        colorGameLogic.newGame(10);

        // L�trehozzuk a komponenseinket �s hozz�adjuk a kerethez a megfelel� elrendez�sben:
        this.infoPanel = new InformationPanel();
        getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.gamePanel = new ColorGamePanel(colorGameLogic, infoPanel);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        this.menuBar = new ColorGameMenuBar();
        setJMenuBar(menuBar);

        // A prefer�lt m�reteket figyelembe v�ve "�sszecsomagoljuk" a komponenseket.
        pack();
    }

    /**
     * Be�ll�tjuk a frame tulajdons�gait
     */
    private void setFrameProperties(){
        setTitle("Color game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100, 100);
        setLayout(new BorderLayout());        
    }

    /**
     * Alkalmazzuk a Nimbus t�m�t.
     */
    private void applyNimbusLookAndFeelTheme(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }             
    }
    
    private class ColorGameMenuBar extends JMenuBar {

        private final JMenu gameMenu;
        private final JMenuItem newGame;        
        
        public ColorGameMenuBar(){
            gameMenu = new JMenu("Game"); // L�trehozunk egy Game nev� men�pontot.
            /*
             *  L�trehozunk egy New game nev� men�elemet, amihez hozz�rendelt�k, a saj�t esem�nykezel�nket.
             */
            newGame = new JMenuItem(newGameAction);
            // Gyors el�r�st seg�t� billenty�kombin�ci�t rendel�nk hozz� az �j j�t�k men�elemhez.
            newGame.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            gameMenu.add(newGame);
            add(gameMenu);
        }
        
        private final Action newGameAction = new AbstractAction("New game") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // A j�t�kok m�ret�t meghat�roz� t�mb:
                final Integer[] gameSizes = new Integer[]{5, 10, 15};
                // Felugr� ablak seg�ts�g�vel v�laszt�st aj�nlunk a j�t�kosnak a m�retek k�z�l.
                final Object resultObject = 
                        JOptionPane.showInputDialog(rootPane, "Select a new game table size",
                                "New game", JOptionPane.QUESTION_MESSAGE, null, gameSizes, gameSizes[0]);
                if (resultObject != null) {
                    // Amennyiben a felhaszn�l� v�sztott valamit, �gy elk�rj�k a v�laszt�s�t �s l�trehozzuk ennek megfelel�en az �j j�t�kot
                    int gameSize = (int) resultObject;
                    colorGameLogic.newGame(gameSize);
                    gamePanel.newGame();
                    infoPanel.newGame();
                    pack();
                }
            }

        };
    }

}
