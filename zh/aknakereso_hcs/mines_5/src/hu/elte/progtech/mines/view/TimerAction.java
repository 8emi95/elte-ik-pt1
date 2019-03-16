package hu.elte.progtech.mines.view;

import java.time.Duration;

import javax.swing.AbstractAction;
import javax.swing.JLabel;

import hu.elte.progtech.mines.model.MinesEngine;

public abstract class TimerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	protected final JLabel timerLabel;
	protected MinesEngine engine;

	public TimerAction(MinesEngine engine, JLabel timerLabel) {
		this.engine = engine;
		this.timerLabel = timerLabel;
	}

	protected String formatDuration(final Duration duration) {
		final long seconds = duration.getSeconds() < 0 ? 0 : duration.getSeconds();
		return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
	}
}