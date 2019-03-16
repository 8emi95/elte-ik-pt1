package hu.elte.progtech.reversi.view;

import static java.awt.BorderLayout.LINE_END;
import static java.awt.BorderLayout.LINE_START;
import static javax.swing.border.BevelBorder.LOWERED;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 7908299393872441615L;

	private JLabel statusLabel;
	private JLabel elapsedTimeLabel;

	public StatusBar() {
		setBorder(new BevelBorder(LOWERED));
		setLayout(new BorderLayout());
		addStatusLabel();
		addTimeLabel();
	}

	private void addStatusLabel() {
		statusLabel = new JLabel("Ready");
		add(statusLabel, LINE_START);
	}

	private void addTimeLabel() {
		elapsedTimeLabel = new JLabel();
		add(elapsedTimeLabel, LINE_END);
	}

	public void setText(String text) {
		statusLabel.setText(text);
	}

	public void updateTime(int seconds) {
		elapsedTimeLabel.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
	}

}
