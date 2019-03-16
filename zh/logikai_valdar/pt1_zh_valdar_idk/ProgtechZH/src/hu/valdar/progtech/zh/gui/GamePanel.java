package hu.valdar.progtech.zh.gui;

import hu.valdar.progtech.zh.logic.GameConstants;
import hu.valdar.progtech.zh.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {

    private final GameLogic gameLogic;
    private final GameInfoPanel gameInfoPanel;

    public GamePanel(GameLogic gameLogic, GameInfoPanel gameInfoPanel) {
        this.gameLogic = gameLogic;
        this.gameInfoPanel = gameInfoPanel;
        newGame();
    }

    public final void newGame() {
        setupGamePanel();
        refreshGamePanel();
    }

    private void setupGamePanel() {
        removeAll();
        setLayout(new GridLayout(GameConstants.BOARD_SIZE, GameConstants.BOARD_SIZE));
        for (int i = 0; i < GameConstants.BOARD_SIZE; ++i) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; ++j) {
                final GameButton gameButton = new GameButton(i, j);
                gameButton.setPreferredSize(new Dimension(60, 60));
                gameButton.addActionListener(gameButtonOnClickAction);
                gameButton.setBackground(Color.GRAY);
                add(gameButton);
            }
        }
    }

    private void refreshGamePanel() {
        for(final Component component : getComponents()){
            final GameButton gameButton = (GameButton) component;
            gameButton.setText(
                    String.valueOf(
                            gameLogic.getFieldValue(gameButton.getPositionX(), gameButton.getPositionY())
                    )
            );
            if (gameLogic.isScore(gameButton.getPositionX(), gameButton.getPositionY())) {
                gameButton.setBackground(Color.BLUE);
            }
            
        }
        gameInfoPanel.setScores(gameLogic.getScores());
        gameInfoPanel.setSteps(gameLogic.getSteps1(), gameLogic.getSteps2());
        checkGameWon();
    }
    
    private void checkGameWon(){
        if(gameLogic.isGameWon()){
            JOptionPane.showMessageDialog(null, "Congratulations! " + gameLogic.getWinner() + " won the game!", "Grats", JOptionPane.INFORMATION_MESSAGE);
            disableAllButton();
        }
    }

    private void disableAllButton() {
        for(final Component component : getComponents()){
            final GameButton gameButton = (GameButton) component;
            gameButton.setEnabled(false);
        }
    }

    private final Action gameButtonOnClickAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent event) {
            final GameButton gameButton = (GameButton) event.getSource();
            int positionX = gameButton.getPositionX();
            int positionY = gameButton.getPositionY();

            gameLogic.modifyValuesFromSource(positionX, positionY);
            refreshGamePanel();
        }
    };

}
