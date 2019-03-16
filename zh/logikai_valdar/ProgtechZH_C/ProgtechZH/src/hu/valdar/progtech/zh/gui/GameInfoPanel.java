package hu.valdar.progtech.zh.gui;

import hu.valdar.progtech.zh.gui.timer.TimerAction;

import javax.swing.*;
import java.awt.*;

public class GameInfoPanel extends JPanel {

    private final JLabel elapsedTimeLabel;
    private final JLabel stepCounterLabel;

    private final Font textFont;

    private Timer elapsedTimeTimer;

    public GameInfoPanel() {
        setPreferredSize(new Dimension(100, 50));
        setBackground(Color.LIGHT_GRAY);
        textFont = new Font("Garamond", Font.ITALIC, 16);

        elapsedTimeLabel = createLabel("", textFont);
        stepCounterLabel = createLabel("", textFont);

        add(createLabel("Elapsed time: ", textFont));
        add(elapsedTimeLabel);
        add(new JLabel("    "));
        add(createLabel("Steps: ", textFont));
        add(stepCounterLabel);

        newGame();
    }

    private JLabel createLabel(String text, Font font) {
        final JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    public final void newGame() {
        stopTimer();
        elapsedTimeLabel.setText("00:00:00");
        setSteps(0);
        elapsedTimeTimer = new Timer(1000, new TimerAction(elapsedTimeLabel));
        elapsedTimeTimer.start();
    }

    public void stopTimer(){
        if (elapsedTimeTimer != null) {
            elapsedTimeTimer.stop();
        }
    }

    public void setSteps(int steps) {
        stepCounterLabel.setText(String.valueOf(steps));
    }

}
