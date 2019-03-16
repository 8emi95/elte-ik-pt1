package hu.elte.progtech.mines.view;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import hu.elte.progtech.mines.model.MinesEngine;

public class ElapsedTimerAction extends TimerAction {

	private static final long serialVersionUID = 1L;

	public ElapsedTimerAction(MinesEngine engine, JLabel timerLabel) {
		super(engine, timerLabel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		timerLabel.setText(formatDuration(engine.getPlayDuration()));
	}

}
