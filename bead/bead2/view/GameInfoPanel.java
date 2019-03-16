package bead2.view;

import javax.swing.*;
import java.awt.*;

import bead2.logic.GameConstants;

public class GameInfoPanel extends JPanel {
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel scoreLabel;
    private JLabel player1ScoreLabel;
    private JLabel player2ScoreLabel;

    public GameInfoPanel() {
        setPreferredSize(new Dimension(100, 85));
        setBackground(Color.DARK_GRAY);
        GridLayout layout = new GridLayout(2,3);
        setLayout(layout);
        createInfoPanel();
        addLabels();
    }

    private void addLabels() {
        add(player1Label);
        add(scoreLabel);
        add(player2Label);
        add(player1ScoreLabel);
        add(new JLabel(""));
        add(player2ScoreLabel);
    }

    private void createInfoPanel() {
        player1Label = createLabel(" Player1", GameConstants.FONT_TYPE_1, Color.WHITE, JLabel.LEFT, 0);
        scoreLabel = createLabel("SCORES", GameConstants.FONT_TYPE_2, Color.ORANGE, JLabel.CENTER, JLabel.BOTTOM);
        player2Label = createLabel("Player2 ", GameConstants.FONT_TYPE_1, Color.WHITE, JLabel.RIGHT, 0);
        player1ScoreLabel = createLabel("", GameConstants.FONT_TYPE_1, GameConstants.PLAYER_1_COLOR, JLabel.RIGHT, JLabel.TOP);
        player2ScoreLabel = createLabel("", GameConstants.FONT_TYPE_1, GameConstants.PLAYER_2_COLOR, JLabel.LEFT, JLabel.TOP);
    }

    private JLabel createLabel(String text, Font fontType, Color fontColor, int hAlign, int vAlign) {
        final JLabel label = new JLabel(text);
        label.setFont(fontType);
        label.setForeground(fontColor);
        label.setHorizontalAlignment(hAlign);
        label.setVerticalAlignment(vAlign);
        return label;
    }

    public void setScores(int player1Scores, int player2Scores) {
        String padding = "  ";
        player1ScoreLabel.setText(String.valueOf(player1Scores) + padding);
        player2ScoreLabel.setText(padding + String.valueOf(player2Scores));
    }
}
