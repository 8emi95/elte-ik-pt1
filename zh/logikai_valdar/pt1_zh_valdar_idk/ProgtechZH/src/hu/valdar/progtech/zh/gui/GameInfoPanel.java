package hu.valdar.progtech.zh.gui;

import javax.swing.*;
import java.awt.*;

public class GameInfoPanel extends JPanel {

    private final JLabel player1Label;
    private final JLabel player2Label;
    private final JLabel scoreLabel;
    private final JLabel scores;
    private final JLabel player1StepCounterLabel;
    private final JLabel player2StepCounterLabel;
    private final Font textFont;
    private final Font textFont2;

    public GameInfoPanel() {
        setPreferredSize(new Dimension(100, 75));
        setBackground(Color.ORANGE);
        textFont = new Font("Arial Narrow", Font.PLAIN, 16);
        textFont2 = new Font("Arial Narrow", Font.BOLD, 23);
        GridLayout layout = new GridLayout(2,3);
        setLayout(layout);
        
        player1Label = createLabel("     Player1", textFont);
        player1Label.setHorizontalAlignment(JLabel.LEFT);
        add(player1Label);
        
        scoreLabel = createLabel("SCORE", textFont2);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        add(scoreLabel);
        
        player2Label = createLabel("Player2     ", textFont);
        player2Label.setHorizontalAlignment(JLabel.RIGHT);
        add(player2Label);
        
        
        player1StepCounterLabel = createLabel("", textFont);
        //add(createLabel("Steps: ", textFont));
        player1StepCounterLabel.setHorizontalAlignment(JLabel.RIGHT);
        player1StepCounterLabel.setVerticalAlignment(JLabel.TOP);
        add(player1StepCounterLabel);
        
        scores = createLabel("", textFont);
        scores.setHorizontalAlignment(JLabel.CENTER);
        scores.setVerticalAlignment(JLabel.TOP);
        add(scores);
        
        player2StepCounterLabel = createLabel("", textFont);
        //add(createLabel("Steps: ", textFont));
        player2StepCounterLabel.setHorizontalAlignment(JLabel.LEFT);
        player2StepCounterLabel.setVerticalAlignment(JLabel.TOP);
        add(player2StepCounterLabel);
        

        newGame();
    }

    private JLabel createLabel(String text, Font font) {
        final JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    public final void newGame() {
        setScores(0);
    }

    public void setScores(int round) {
        scores.setText(String.valueOf(round));
    }
    
    public void setSteps(int steps1, int steps2) {
        String padding = "                  ";
        player1StepCounterLabel.setText(String.valueOf(steps1) + padding);
        player2StepCounterLabel.setText(padding + String.valueOf(steps2));
    }

}
