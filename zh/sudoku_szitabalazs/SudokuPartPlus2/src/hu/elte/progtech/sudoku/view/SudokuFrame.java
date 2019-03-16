package hu.elte.progtech.sudoku.view;

import static java.awt.BorderLayout.LINE_END;
import static java.awt.BorderLayout.LINE_START;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.GRAY;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import hu.elte.progtech.sudoku.model.SudokuEngine;
import hu.elte.progtech.sudoku.model.SudokuView;

public class SudokuFrame extends JFrame implements SudokuView {

	private static final long serialVersionUID = -5787540942793940226L;

	private static final String EMPTY = "";
	private static final String DIALOG_TITLE = "New game";
	private static final String DIALOG_TEXT = "You won.\nPlay again?";
	private static final String NEW_GAME_LABEL = "New Game";
	private static final String CHOOSE_SIZE = "Please choose the board size";

	private SudokuEngine engine;
	private Container topContainer;
	private JLabel timerLabel;
	private Container bottomContainer;

	public void setModel(SudokuEngine engine) {
		this.engine = engine;
	}

	public void showFrame() {
		setTitle("Sudoku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addTopPart();
		setVisible(true);
		pack();
	}

	private void addTopPart() {
		topContainer = new Container();
		topContainer.setLayout(new BorderLayout());
		addNewGameButton();
		addTimerLabel();
		getContentPane().add(topContainer, NORTH);
	}

	private void addNewGameButton() {
		JButton newGameButton = new JButton(NEW_GAME_LABEL);
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startNewGame();
			}
		});
		topContainer.add(newGameButton, LINE_START);
	}

	private void startNewGame() {
		Object selected = JOptionPane.showInputDialog(this, CHOOSE_SIZE, DIALOG_TITLE, DEFAULT_OPTION, null,
				getAvailableSizeLabels(), null);
		if (selected != null) {
			SizeLabel selectedSize = (SizeLabel) selected;
			engine.startNewGame(selectedSize.getBoardSize());
		} else {
			// Nothing to do.
		}
	}

	private SizeLabel[] getAvailableSizeLabels() {
		int[] sizes = engine.getAvailableSizes();
		SizeLabel[] sizeLabels = new SizeLabel[sizes.length];
		for (int i = 0; i < sizes.length; ++i) {
			sizeLabels[i] = new SizeLabel(sizes[i]);
		}
		return sizeLabels;
	}

	private void addTimerLabel() {
		timerLabel = new JLabel();
		timerLabel.setBorder(new CompoundBorder(timerLabel.getBorder(), new EmptyBorder(0, 0, 0, 10)));
		topContainer.add(timerLabel, LINE_END);
	}

	@Override
	public void newGame() {
		if (bottomContainer != null) {
			getContentPane().remove(bottomContainer);
		}
		addBottomPart();
		pack();
	}

	private void addBottomPart() {
		bottomContainer = new Container();
		bottomContainer.setLayout(new GridLayout(engine.getSize(), engine.getSize()));
		addFields();
		getContentPane().add(bottomContainer, SOUTH);
	}

	private void addFields() {
		for (int i = 0; i < engine.getSize(); ++i) {
			for (int j = 0; j < engine.getSize(); ++j) {
				addField(i, j);
			}
		}
	}

	private void addField(int row, int column) {
		JButton field = new JButton(getLabelOfField(row, column));
		setBordersOfField(row, column, field);
		field.setPreferredSize(new Dimension(40, 40));
		field.setFont(field.getFont().deriveFont(getFontStyleOfField(row, column)));
		field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					engine.changeValue(row, column);
				} else if (SwingUtilities.isRightMouseButton(e)) {
					engine.clearValue(row, column);
				}
			}
		});
		bottomContainer.add(field);
	}

	private String getLabelOfField(int row, int column) {
		return getValueLabel(engine.getValue(row, column));
	}

	private String getValueLabel(int value) {
		return value == 0 ? EMPTY : Integer.toString(value);
	}

	private void setBordersOfField(int row, int column, JButton field) {
		int topBorder = row % engine.getBlockSize() == 0 ? 4 : 1;
		int leftBorder = column % engine.getBlockSize() == 0 ? 4 : 1;
		int bottomBorder = row == engine.getSize() - 1 ? 4 : 1;
		int rightBorder = column == engine.getSize() - 1 ? 4 : 1;
		field.setBorder(BorderFactory.createMatteBorder(topBorder, leftBorder, bottomBorder, rightBorder, GRAY));
	}

	private int getFontStyleOfField(int row, int column) {
		return engine.isPredefined(row, column) ? BOLD : PLAIN;
	}

	@Override
	public void update(int row, int column, int value) {
		try {
			Component comp = bottomContainer.getComponent(row * engine.getSize() + column);
			JButton field = (JButton) comp;
			field.setText(getValueLabel(value));
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			// Nothing to do.
		}
	}

	@Override
	public void completed() {
		int answer = JOptionPane.showConfirmDialog(this, DIALOG_TEXT, DIALOG_TITLE, YES_NO_OPTION);
		if (answer == YES_OPTION) {
			startNewGame();
		}
	}

	@Override
	public void updateTime(int currentTime) {
		int mins = currentTime / 60;
		int seconds = currentTime % 60;
		if (timerLabel != null) {
			timerLabel.setText(String.format(getTimeFormat(), mins, seconds));
		}
	}

	private String getTimeFormat() {
		return "%02d:%02d";
	}

}
