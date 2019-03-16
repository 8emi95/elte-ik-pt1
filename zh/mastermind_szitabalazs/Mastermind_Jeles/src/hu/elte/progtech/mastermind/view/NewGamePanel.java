package hu.elte.progtech.mastermind.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class NewGamePanel extends JPanel {

	private static final long serialVersionUID = -1324709472563819524L;

	private Integer selectedColorCount;

	public NewGamePanel(int[] availableColors) {
		for (int i = 0; i < availableColors.length; ++i) {
			addButton(availableColors, i);
		}
	}

	private void addButton(int[] availableColors, int i) {
		JRadioButton button = new JRadioButton(Integer.toString(availableColors[i]));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedColorCount = availableColors[i];
			}
		});
		add(button);
	}

	public Integer getSelectedColorCount() {
		return selectedColorCount;
	}
}
