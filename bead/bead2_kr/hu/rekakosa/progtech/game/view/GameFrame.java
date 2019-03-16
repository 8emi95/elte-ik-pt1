package hu.rekakosa.progtech.game.view;

import hu.rekakosa.progtech.game.logic.GameConstants;
import hu.rekakosa.progtech.game.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GameFrame extends JFrame {

    private final GameLogic gameLogic;
    private final GamePanel gamePanel;
    private final GameInfoPanel gameInfoPanel;
    private final JMenuBar menuBar;

    public GameFrame(GameLogic gameLogic) {
        setFrameProperties();
        applyNimbusLookAndFeelTheme();

        this.gameLogic = gameLogic;
        this.gameInfoPanel = new GameInfoPanel();
        this.gamePanel = new GamePanel(gameLogic, gameInfoPanel);
        
        add(gameInfoPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        this.menuBar = new GameMenuBar();
        setJMenuBar(menuBar);

        pack();
    }

    private void setFrameProperties() {
        setTitle("ultimate source of happiness for Balázs");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        pack();
    }
    
    private class GameMenuBar extends JMenuBar {

        private final JMenu gameMenu;
        private final JMenuItem newGame;        
        
        public GameMenuBar(){
            gameMenu = new JMenu("Game"); 
            newGame = new JMenuItem(newGameAction);
            gameMenu.add(newGame);
            add(gameMenu);
        }
        
        private final Action newGameAction = new AbstractAction("New game") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gamePanel.newGame();
            }
        };
    }
    
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
