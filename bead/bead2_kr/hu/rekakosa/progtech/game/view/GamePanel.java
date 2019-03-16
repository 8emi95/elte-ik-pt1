package hu.rekakosa.progtech.game.view;

import hu.rekakosa.progtech.game.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {

    private final GameLogic gameLogic;
    private final GameInfoPanel gameInfoPanel;
    private Player actualPlayer;

    public GamePanel(GameLogic gameLogic, GameInfoPanel gameInfoPanel) {
        setBackground(GameConstants.GAME_PANEL_BACKGROUND_COLOR);
        this.gameInfoPanel = gameInfoPanel;
        this.gameLogic = gameLogic;
        actualPlayer = gameLogic.getActualPlayer();
        initializeGamePanel(GameConstants.DEFAULT_BOARD_SIZE);
    }
    
    public final void newGame() {
        final Object resultObject = JOptionPane.showInputDialog(null, GameConstants.NEW_GAME_TEXT,
                                    "New game", JOptionPane.QUESTION_MESSAGE, null, 
                                    GameConstants.BOARD_SIZES, GameConstants.BOARD_SIZES[0]);
        if (resultObject != null) {
            int boardSize = (int) resultObject;
        initializeGamePanel(boardSize);
        }
    }
    
    private void initializeGamePanel(int boardSize) {
        gameLogic.createNewGame(boardSize);
        setupGamePanel();
        refreshGamePanel();
    }


    private void setupGamePanel() {
        removeAll();
        setLayout(new GridLayout(gameLogic.getBoardSize(), gameLogic.getBoardSize()));
        for (int i = 0; i < gameLogic.getBoardSize(); ++i) {
            for (int j = 0; j < gameLogic.getBoardSize(); ++j) {
                final GameButton gameButton = new GameButton(i, j);
                setupGameButton(gameButton);
                add(gameButton);
            }
        }
    }
    
    private void setupGameButton(final GameButton gameButton) {
        gameButton.setPreferredSize(new Dimension(GameConstants.GAME_BUTTON_SIZE, GameConstants.GAME_BUTTON_SIZE));
        gameButton.addActionListener(gameButtonOnClickAction);
        gameButton.setBackground(Color.DARK_GRAY);
        gameButton.setForeground(Color.WHITE);
        
    }
    private void refreshGamePanel() {
        for (final Component component : getComponents()){
            
            final GameButton gameButton = (GameButton) component;
            gameButton.setText(String.valueOf(gameLogic.getFieldValue(gameButton.getPositionX(), gameButton.getPositionY()))
            );
            
            if (gameLogic.isScore(gameButton.getPositionX(), gameButton.getPositionY()) && isFieldUnaffected(gameButton)) {    
                    gameButton.setBackground(buttonBackground());
            }              
        }
        gameInfoPanel.setScores(gameLogic.getPlayer1Scores(), gameLogic.getPlayer2Scores());
        checkGameWon();
    }
    
    private boolean isFieldUnaffected(final GameButton gameButton) {
        return (gameButton.getBackground() == Color.DARK_GRAY);
    }
    private Color buttonBackground() {
       return (actualPlayer == Player.ONE) ? GameConstants.PLAYER_1_COLOR : GameConstants.PLAYER_2_COLOR; 
    }
    
    private void checkGameWon(){
        if(gameLogic.isGameWon()){
            
            JOptionPane.showMessageDialog(null, "Congratulations! " + gameLogic.getWinner() + " won the game.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            newGame();
        }
        
    }

    private final Action gameButtonOnClickAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent event) {
            final GameButton gameButton = (GameButton) event.getSource();
            int positionX = gameButton.getPositionX();
            int positionY = gameButton.getPositionY();

            gameLogic.modifyValuesFromSource(positionX, positionY);
            actualPlayer = gameLogic.getActualPlayer().getOpponent();
            refreshGamePanel();
        }
    };

}
