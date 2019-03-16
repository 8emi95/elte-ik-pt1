package hu.valdar.progtech.zh.gui;

import hu.valdar.progtech.zh.logic.GameConstants;
import hu.valdar.progtech.zh.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GameFrame extends JFrame {

    private final GameLogic gameLogic;
    private final GamePanel gamePanel;
    private final GameInfoPanel gameInfoPanel;

    public GameFrame(GameLogic gameLogic) {
        setFrameProperties();
        applyNimbusLookAndFeelTheme();

        this.gameLogic = gameLogic;
        this.gameInfoPanel = new GameInfoPanel();
        this.gamePanel = new GamePanel(gameLogic, gameInfoPanel);

        setJMenuBar(new GameMenuBar());
        add(gameInfoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        pack();
    }

    private void setFrameProperties() {
        setTitle(GameConstants.TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private class GameMenuBar extends JMenuBar {
        private final JMenu gameMenu;
        private final JMenuItem newGameMenuItem;

        public GameMenuBar() {
            gameMenu = new JMenu("Game");
            newGameMenuItem = new JMenuItem(newGameAction);
            newGameMenuItem.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            gameMenu.add(newGameMenuItem);
            add(gameMenu);
        }

        private final Action newGameAction = new AbstractAction("New game") {
            @Override
            public void actionPerformed(ActionEvent event) {
                final int result = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to start a new game?",
                        "New game",
                        JOptionPane.YES_NO_OPTION
                );

                if(result == JOptionPane.YES_OPTION){
                    gameLogic.createNewGame();
                    gamePanel.newGame();
                    gameInfoPanel.newGame();
                }
            }
        };
    }

    // Szebb kinézetre (Nem volt a feladat része):
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

}
