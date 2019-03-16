package mastermind.view;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import mastermind.model.MastermindEngine;
import mastermind.model.MastermindView;

public class MastermindFrame extends JFrame implements MastermindView {

    private static final long serialVersionUID = 8088978051608863877L;

    private static final String GUESS_LABEL = "TIPP";

    private MastermindEngine engine;
    private List<Color> colors;
    private Container topPart;
    private JButton guessButton;

    public MastermindFrame() {
        super("Mastermind");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setModel(MastermindEngine engine) {
        this.engine = engine;
    }

    public void showFrame() {
        addTopPart();
        addBottomPart();
        setVisible(true);
        pack();
    }

    private void addTopPart() {
        topPart = new Container();
        topPart.setLayout(new GridLayout(engine.getGuessCount(), engine.getColorCount()));
        for (int i = 0; i < engine.getGuessCount(); ++i) {
            for (int j = 0; j < engine.getColorCount(); ++j) {
                addButton(i, j);
            }
        }
        getContentPane().add(topPart, NORTH);
    }

    private void addButton(int i, int j) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(30, 30));
        button.setEnabled(engine.getCurrentGuess() == i);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.clicked(i, j);
            }
        });
        topPart.add(button);
    }

    private void addBottomPart() {
        Container bottomPart = new Container();
        bottomPart.setLayout(new BorderLayout());
        guessButton = new JButton(GUESS_LABEL);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.guess();
            }
        });
        bottomPart.add(guessButton, CENTER);
        getContentPane().add(bottomPart, SOUTH);
    }

    @Override
    public void startNewGame() {
        selectColors();
        showCheat();
    }

    private void selectColors() {
        colors = new ArrayList<>(6);
        colors.add(RED);
        colors.add(GREEN);
        colors.add(BLUE);
        colors.add(YELLOW);
        colors.add(WHITE);
        colors.add(BLACK);
        Collections.shuffle(colors);
        colors.removeAll(colors.subList(0, colors.size() - engine.getColorCount()));
    }

    @Deprecated
    private void showCheat() {
        System.out.println("Color-value mapping:");
        System.out.println("  0: blank");
        for (int i = 0; i < colors.size(); ++i) {
            System.out.println(String.format("  %d: %s", i + 1, colors.get(i).toString()));
        }
    }

    @Override
    public void update(int guess, int item, int value) {
        getButton(guess, item).setBackground(getBackgroundOfButton(value));
    }

    private JButton getButton(int guess, int item) {
        Component component = topPart.getComponent(guess * engine.getColorCount() + item);
        return (JButton) component;
    }

    private Color getBackgroundOfButton(int value) {
        return colors.get(value - 1);
    }

    @Override
    public void updateLine(int guess) {
        for (int item = 0; item < engine.getColorCount(); ++item) {
            getButton(guess, item).setEnabled(guess == engine.getCurrentGuess());
        }
    }

    @Override
    public void noMoreGuesses() {
        guessButton.setEnabled(false);
    }

}