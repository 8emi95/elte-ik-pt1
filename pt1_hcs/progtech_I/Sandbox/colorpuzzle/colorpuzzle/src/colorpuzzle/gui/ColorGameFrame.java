package colorpuzzle.gui;

import colorpuzzle.logic.ColorGameLogic;

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

public class ColorGameFrame extends JFrame {

    private final ColorGameLogic colorGameLogic;
    private final ColorGamePanel gamePanel;
    private final JMenuBar menuBar;
    private final InformationPanel infoPanel;
    
    public ColorGameFrame(final ColorGameLogic colorGameLogic) {
        this.colorGameLogic = colorGameLogic;
        setFrameProperties();
        applyNimbusLookAndFeelTheme();
        // Kezdetben 8x8-as játéktáblát hozunk létre.
        colorGameLogic.newGame(8);

        // Létrehozzuk a komponenseinket és hozzáadjuk a kerethez a megfelelő elrendezésben:
        this.infoPanel = new InformationPanel();
        getContentPane().add(infoPanel, BorderLayout.NORTH);
        this.gamePanel = new ColorGamePanel(colorGameLogic, infoPanel);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        this.menuBar = new ColorGameMenuBar();
        setJMenuBar(menuBar);

        // A preferált méreteket figyelembe véve "összecsomagoljuk" a komponenseket.
        pack();
    }

    /**
     * Beállítjuk a frame tulajdonságait
     */
    private void setFrameProperties(){
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100, 100);
        setLayout(new BorderLayout());        
    }

    /**
     * Alkalmazzuk a Nimbus témát.
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
            gameMenu = new JMenu("Game"); // Létrehozunk egy Game nevű menüpontot.
            /*
             *  Létrehozunk egy New game nevű menüelemet, amihez hozzárendeltük, a saját eseménykezelőnket.
             */
            newGame = new JMenuItem(newGameAction);
            // Gyors elérést segítő billentyűkombinációt rendelünk hozzá az új játék menüelemhez.
            newGame.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            gameMenu.add(newGame);
            add(gameMenu);
        }
        
        private final Action newGameAction = new AbstractAction("New game") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                // A játékok méretét meghatározó tömb:
                final Integer[] gameSizes = new Integer[]{5, 10, 15};
                // Felugró ablak segítségével választást ajánlunk a játékosnak a méretek közül.
                final Object resultObject = 
                        JOptionPane.showInputDialog(rootPane, "Select a new game table size",
                                "New game", JOptionPane.QUESTION_MESSAGE, null, gameSizes, gameSizes[0]);
                if (resultObject != null) {
                    // Amennyiben a felhasználó vásztott valamit, úgy elkérjük a választását és létrehozzuk ennek megfelelően az új játékot
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
