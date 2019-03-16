package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QueenController;

public class ColorFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel mainPanel = new JPanel();
	private JPanel boardPanel = new JPanel();
	private JButton stepButton;

	private QueenController controller = new QueenController();

	public ColorFrame() {
		init();
		addSizeButtons();
		controller.initTable(4);
		addBoard(controller.getSize());
	}

	private void init() {
		setTitle("ColorGame");
		setSize(590, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel.setLayout(new BorderLayout(10, 10));
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

		add(mainPanel);
	}

	private void addSizeButtons() {
		JPanel sizePanel = new JPanel();

		for (int i = 0; i < 3; ++i) {
			int size = 4 + i * 2;
			String sizeString = Integer.toString(size);
			JButton button = new JButton(sizeString + "x" + sizeString);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					newGame(size);
				}
			});
			sizePanel.add(button);
		}
		stepButton = new JButton("Steps: 0");
		stepButton.setEnabled(false);
		sizePanel.add(stepButton);

		mainPanel.add(sizePanel, BorderLayout.PAGE_START);
	}

	private void addBoard(int size) {
		boardPanel.removeAll();
		boardPanel.setLayout(new GridLayout(size, size));

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				final int x = i;
				final int y = j;
				JButton button = new JButton();
				Color c = controller.getColor(i, j);
				button.setBackground(c);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setNeighboursToNextColor(x, y);
						controller.increaseSteps();
						stepButton.setText("Steps: " + controller.getSteps());
						if (controller.isFinishedGame()) {
							showWindow();
							controller.initStep();
							newGame(size);
						}
					}
				});
				boardPanel.add(button);
			}
		}

		mainPanel.add(boardPanel, BorderLayout.CENTER);
	}

	private void newGame(int size) {
		controller.initTable(size);
		boardPanel.revalidate();
		boardPanel.removeAll();
		boardPanel.repaint();
		addBoard(controller.getSize());
		controller.initStep();
		stepButton.setText("Steps: 0");
	}

	private void setNeighboursToNextColor(int i, int j) {
		for (int x = i - 1; x <= i + 1; ++x) {
			for (int y = j - 1; y <= j + 1; ++y) {
				int size = controller.getSize();
				if (x >= 0 && x < size && y >= 0 && y < size) {
					JButton button = (JButton) boardPanel.getComponent(x * size + y);
					Color c = button.getBackground();
					button.setBackground(controller.nextColor(c));
				}
			}
		}
	}

	private void showWindow() {
		JOptionPane.showMessageDialog(this, "You are the winner! Steps: "
				+ controller.getSteps(), "Game finished",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
