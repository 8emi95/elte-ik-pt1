package hu.elte.progtech.mines.view;

import static java.awt.Font.ITALIC;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import hu.elte.progtech.mines.model.MinesEngine;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel elapsedTimeTextLabel;
	private JLabel elapsedTimeLabel;

	private JLabel remainingTimeTextLabel;
	private JLabel remainingTimeLabel;

	private JLabel stepCounterTextLabel;
	private JLabel stepCounterLabel;

	private Font textFont;

	private Timer elapsedTime;
	private Timer remainingTime;

	public InfoPanel(MinesEngine engine) {
		// setPreferredSize(new Dimension(200, 200));
		textFont = new Font("Garamond", ITALIC, 16);

		addElapsedTimeField(engine);
		add(new JLabel("|"));
		addRemainingTimeField(engine);
		add(new JLabel("|"));
		addStepsField();
	}

	private void addStepsField() {
		stepCounterTextLabel = createLabel("Steps: ", textFont);
		stepCounterLabel = createLabel("", textFont);
		add(stepCounterTextLabel);
		add(stepCounterLabel);
		setSteps(0);
	}

	private void addRemainingTimeField(MinesEngine engine) {
		remainingTimeTextLabel = createLabel("Remaining time: ", textFont);
		remainingTimeLabel = createLabel("", textFont);
		add(remainingTimeTextLabel);
		add(remainingTimeLabel);
		remainingTimeLabel.setText("00:00:00");
		remainingTime = new Timer(1000, new RemainingTimerAction(engine, remainingTimeLabel));
		remainingTime.start();
	}

	private void addElapsedTimeField(MinesEngine engine) {
		elapsedTimeTextLabel = createLabel("Elapsed time: ", textFont);
		elapsedTimeLabel = createLabel("", textFont);
		add(elapsedTimeTextLabel);
		add(elapsedTimeLabel);
		elapsedTimeLabel.setText("00:00:00");
		elapsedTime = new Timer(1000, new ElapsedTimerAction(engine, elapsedTimeLabel));
		elapsedTime.start();
	}

	private JLabel createLabel(String text, Font font) {
		final JLabel label = new JLabel(text);
		label.setFont(font);
		return label;
	}

	public void setSteps(int steps) {
		stepCounterLabel.setText(String.valueOf(steps));
	}
}
