package game.view;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import game.engine.GameEngine;

public class ElapsedTimerAction extends TimerAction {

	private static final long serialVersionUID = 1L;

	public ElapsedTimerAction(GameEngine engine, JLabel timerLabel) {
		super(engine, timerLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timerLabel.setText(formatDuration(engine.getPlayDuration()));
	}

}
