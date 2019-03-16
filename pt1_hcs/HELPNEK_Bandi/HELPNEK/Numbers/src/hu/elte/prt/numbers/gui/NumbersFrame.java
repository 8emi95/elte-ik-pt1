package hu.elte.prt.numbers.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import hu.elte.prt.numbers.model.NumbersEngine;
import hu.elte.prt.numbers.model.NumbersGUI;

public class NumbersFrame extends JFrame implements NumbersGUI {

    private static final long serialVersionUID = -5285520594526000882L;

    private NumbersEngine engine;
    private JPanel fieldsPanel;
    private JSpinner sizeSpinner;

    public NumbersFrame(NumbersEngine engine) {
	super("Numbers Game");
	this.engine = engine;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showFrame() {
	getContentPane().setLayout(new BorderLayout());
	getContentPane().add(createNewGamePanel(), BorderLayout.NORTH);
	getContentPane().add(createFieldsPanel(), BorderLayout.CENTER);
	pack();
	setVisible(true);
    }

    private JPanel createNewGamePanel() {
	JPanel newGamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JLabel sizeLabel = new JLabel("Size: ");
	sizeSpinner = new JSpinner(new SpinnerNumberModel(5, 3, 8, 1));
	JButton newGameButton = createNewGameButton();
	newGamePanel.add(sizeLabel);
	newGamePanel.add(sizeSpinner);
	newGamePanel.add(newGameButton);
	return newGamePanel;
    }

    private JButton createNewGameButton() {
	JButton newGameButton = new JButton("New Game");
	newGameButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		engine.newGame((int) sizeSpinner.getValue());
	    }
	});
	return newGameButton;
    }

    private JPanel createFieldsPanel() {
	fieldsPanel = new JPanel(new GridLayout(engine.getSize(), engine.getSize()));
	for (int i = 0; i < engine.getSize(); ++i) {
	    for (int j = 0; j < engine.getSize(); ++j) {
		NumbersField field = new NumbersField(i, j);
		addActionListener(field, i, j);
		fieldsPanel.add(field);
	    }
	}
	return fieldsPanel;
    }

    private void addActionListener(NumbersField field, int i, int j) {
	field.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.select(i, j);
	    }
	});
    }

    @Override
    public void newGame() {
	if (null != fieldsPanel) {
	    fieldsPanel.removeAll();
	    getContentPane().remove(fieldsPanel);
	    getContentPane().add(createFieldsPanel(), BorderLayout.CENTER);
	    pack();
	}
    }

    @Override
    public void updateGame() {
	for (Component c : fieldsPanel.getComponents()) {
	    NumbersField field = (NumbersField) c;
	    field.setText(getText(field));
	    field.setForeground(getFieldTextColor(field));
	}
    }

    private String getText(NumbersField field) {
	int intValue = engine.getValue(field.getRow(), field.getColumn());
	return 0 == intValue ? "" : Integer.toString(intValue);
    }

    private Color getFieldTextColor(NumbersField field) {
	boolean selected = engine.isSelected(field.getRow(), field.getColumn());
	return selected ? Color.BLACK : Color.GRAY;
    }

    @Override
    public void lost() {
	JOptionPane.showMessageDialog(this, "You lost.");
	engine.newGame((int) sizeSpinner.getValue());
    }

}
