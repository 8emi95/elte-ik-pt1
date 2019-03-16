package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.KnightController;

public class GameBoardAction implements ActionListener {
	private final int x;
	private final int y;

	private KnightFrame knightFrame;
	private KnightController controller = new KnightController();
	private JPanel boardPanel = new JPanel();
	private int size;

	public GameBoardAction(KnightFrame knightFrame, KnightController controller, JPanel boardPanel, int size, int x, int y) {
		this.knightFrame = knightFrame;
		this.controller = controller;
		this.boardPanel = boardPanel;
		this.size = size;
		this.x = x;
		this.y = y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		liftKnight();
		controller.step(x, y);
		putKnight(e.getSource());

		knightFrame.modifyStepLabelText();
		knightFrame.moveKnight();
		if (controller.isFinishedGame()) {
			knightFrame.showWindow();
			controller.initStep();
			knightFrame.newGame(size);
		}
	}

	private void liftKnight() {
		int oldX = controller.getKnightX();
		int oldY = controller.getKnightY();
		JButton oldKnightButton = (JButton) boardPanel.getComponent(oldX * size + oldY);
		oldKnightButton.setText("");
		oldKnightButton.setBackground(controller.getDisturbedColor());
	}

	private void putKnight(Object source) {
		JButton button = (JButton) source;
		button.setBackground(controller.getColor(x, y));
	}
}
