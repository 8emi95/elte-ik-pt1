package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.KnightController;

public class KnightFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final String KNIGHT = "K";
	private static final int DEFAULT_SIZE = 6;
	private static final String STEPS = "Steps: ";

	private KnightController controller = new KnightController();

	private JPanel mainPanel = new JPanel();
	private JPanel boardPanel = new JPanel();
	private JButton stepButton = new JButton();

	public KnightFrame() {
		initFrame();
		newGame(DEFAULT_SIZE);
		addSelectorButtons();
	}

	private void initFrame() {
		setTitle("Knight game");
		setSize(490, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel.setLayout(new BorderLayout(10, 10));
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

		add(mainPanel);
	}

	public void newGame(int size) {
		clearBoard();
		controller.initStep();
		controller.initTable(size);
		addGameTable(size);
		modifyStepLabelText();
	}

	private void clearBoard() {
		boardPanel.revalidate();
		boardPanel.removeAll();
		boardPanel.repaint();
	}

	private void addGameTable(int size) {
		boardPanel.removeAll();
		boardPanel.setLayout(new GridLayout(size, size));

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				final int x = i;
				final int y = j;
				JButton button = new JButton();
				button.setBackground(controller.getColor(i, j));
				button.addActionListener(new GameBoardAction(this, controller, boardPanel, size, x, y));
				boardPanel.add(button);
			}
		}
		moveKnight();
		mainPanel.add(boardPanel, BorderLayout.CENTER);
	}

	public void showWindow() {
		JOptionPane.showMessageDialog(this,
				"Winner! Steps: " + controller.getSteps(), "Game finished",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void modifyStepLabelText() {
		stepButton.setText(STEPS + controller.getSteps());
	}

	public void moveKnight() {
		int knightX = controller.getKnightX();
		int knightY = controller.getKnightY();

		JButton knightButton = (JButton) boardPanel.getComponent(knightX * controller.getSize() + knightY);
		knightButton.setText(KNIGHT);
		knightButton.setBackground(controller.getColor(knightX, knightY));
	}

	private void addSelectorButtons() {
		JPanel selectorPanel = new JPanel();

		for (int i = 0; i < 3; ++i) {
			int size = DEFAULT_SIZE + i * 2;
			String sizeString = Integer.toString(size);
			JButton button = new JButton(sizeString + "x" + sizeString);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					newGame(size);
				}
			});
			selectorPanel.add(button);
		}

		addStepButton(selectorPanel);
		mainPanel.add(selectorPanel, BorderLayout.PAGE_START);
	}

	private void addStepButton(JPanel selectorPanel) {
		modifyStepLabelText();
		stepButton.setEnabled(false);
		selectorPanel.add(stepButton);
	}
}
