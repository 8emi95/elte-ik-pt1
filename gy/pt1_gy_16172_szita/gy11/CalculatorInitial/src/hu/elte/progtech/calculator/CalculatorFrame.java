package hu.elte.progtech.calculator;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.SwingConstants.TRAILING;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {

    private static final long serialVersionUID = 3332541000093466348L;
    private JTextField display;
    private int firstArgument;
    private boolean firstArgumentEntered;
    private int result;
    private JButton plusButton;

    public CalculatorFrame(String title) {
        super(title);

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(TRAILING);
        display.setEditable(false);
        add(display, NORTH);

        Container container = new Container();
        container.setLayout(new GridLayout(4, 3));

        for (int i = 1; i < 10; ++i) {
            addButton(container, Integer.toString(i));
        }
        plusButton = addButton(container, "+");
        addButton(container, "0");
        addButton(container, "=");
        add(container, SOUTH);
    }

    private JButton addButton(Container container, String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setPreferredSize(new Dimension(100, 100));

        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("+".equals(label)) {
                    button.setEnabled(false);
                    firstArgument = Integer.parseInt(display.getText());
                    firstArgumentEntered = true;
                } else if ("=".equals(label)) {
                    result = firstArgument + Integer.parseInt(display.getText());
                    display.setText(Integer.toString(result));
                    plusButton.setEnabled(true);
                } else {
                    if ("0".equals(display.getText()) || firstArgumentEntered) {
                        display.setText(label);
                        firstArgumentEntered = false;
                    } else {
                        display.setText(display.getText() + label);
                    }
                }
            }
        };
        button.addActionListener(l);
        container.add(button);
        return button;
    }

}
