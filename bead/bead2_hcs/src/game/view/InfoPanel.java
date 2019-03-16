package game.view;

import static java.awt.Font.ITALIC;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.engine.GameEngine;

public class InfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel elapsedTimeTextLabel;
	private JLabel elapsedTimeLabel;
	private Font textFont;

	private Timer elapsedTime;

	public InfoPanel(GameEngine engine) {
		textFont = new Font("Garamond", ITALIC, 16);

		addElapsedTimeField(engine);
	}

	private void addElapsedTimeField(GameEngine engine) {
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

}
