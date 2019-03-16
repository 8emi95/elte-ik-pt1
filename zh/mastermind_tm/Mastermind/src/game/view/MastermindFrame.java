package game.view;

import game.model.MastermindEngine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

import static game.model.MastermindEngine.COLOR_COUNTY;
import static game.model.MastermindEngine.TRY_SIZE;


public class MastermindFrame extends JFrame {

    public static final int BWIDTH = 80;
    public static final int BHEIGHT = 60;
    private MastermindEngine engine;
    private JPanel gamepanel;
    private JPanel labelpanel;
    private JPanel buttonpanel;


    public MastermindFrame(MastermindEngine engine) {
        super("Mastermind Simple");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamepanel = new JPanel();
        gamepanel.setLayout(new GridLayout(TRY_SIZE, COLOR_COUNTY));
        getContentPane().add(gamepanel, BorderLayout.WEST);
        labelpanel = new JPanel();
        labelpanel.setLayout(new GridLayout(TRY_SIZE, COLOR_COUNTY));
        getContentPane().add(labelpanel, BorderLayout.EAST);
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonpanel, BorderLayout.SOUTH);
        this.engine = engine;

    }

    public void showFrame() {

        createFields();
        createLabels();
        setBottomButton();
        pack();
        setMenu();
        setVisible(true);
    }

    private void createLabels() {
        for (int i = 0; i < TRY_SIZE; i++) {
            labelpanel.add(createLabel());
        }
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Szerepelt : 0 ** Eltalált : 0");
        return label;
    }

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);
        addRestartMenuItem(menu);
        setJMenuBar(menuBar);
    }

    private void setBottomButton() {
        JButton bottombutton = new JButton("Next");
        bottombutton.setPreferredSize(new Dimension(80, 60));
        bottombutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.next();
                updateLabels();
                checkVictoryCondition();
                updateFields();

            }
        });
        buttonpanel.add(bottombutton);

    }

    private void updateLabels() {
        for(int i = 0 ; i < TRY_SIZE;i++){
            Component c = labelpanel.getComponent(i);
            JLabel label = (JLabel) c;
            updateLabel(label,i);
        }
    }

    private void updateLabel(JLabel label,int i) {
        int qty = engine.isInside(i);
        int inPlace = engine.isCorrect(i);
        label.setText("Szerepelt : "+qty+" ** Eltalált : "+ inPlace);
    }

    private void addRestartMenuItem(JMenu menu) {
        JMenuItem menuItem = new JMenuItem("New game");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                engine.startNewGame();
                updateFields();
                updateLabels();
            }
        });
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menu.add(menuItem);
    }

    private void createFields() {

        for (int i = 0; i < TRY_SIZE; i++) {
            for (int j = 0; j < COLOR_COUNTY; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(BWIDTH, BHEIGHT));
                addActionListener(button, i, j);
                gamepanel.add(button);
            }
        }

        updateFields();
    }

    private void addActionListener(JButton button, int i, int j) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.click(i, j);
                updateFields();
                checkVictoryCondition();
            }
        });
    }


    public void updateFields() {
        for (int i = 0; i < TRY_SIZE; i++) {
            for (int j = 0; j < COLOR_COUNTY; j++) {
                Component c = gamepanel.getComponent(i * COLOR_COUNTY + j);
                JButton field = (JButton) c;
                field.setBackground(engine.getBackgroundColor(i, j));

            }
        }
    }

    private void checkVictoryCondition() {
        if (engine.isGameOverWin()) {
            int answer = JOptionPane.showConfirmDialog(this, "Congratulations Bitch.Wanna play again?" , "GameOver" , JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION){
                engine.startNewGame();
                updateFields();
                updateLabels();
            } else {
                System.exit(0);
            }
        }
        if (engine.isGameOver()) {
            JOptionPane.showMessageDialog(this, "Fail.");
        }
    }
}