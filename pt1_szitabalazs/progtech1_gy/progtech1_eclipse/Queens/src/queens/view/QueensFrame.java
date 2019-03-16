package queens.view;

import static java.awt.Color.GRAY;
import static java.awt.Color.WHITE;
import static java.awt.Color.GREEN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import queens.model.QueensEngine;

public class QueensFrame extends JFrame {
    private static final int YES_NO_OPTION = JOptionPane.YES_NO_OPTION;
    private static final String PLAY_AGAIN = "You won!\nWanna play again, mate?";

    private static final long serialVersionUID = 2265228622194396011L;

    private static final String QUEEN = "Q";
    private static final String EMPTY = "";
    private static final String RESTART = "Restart";
    private static final String UNDO = "Undo";
    private static final String PAUSE = "Pause";

    private QueensEngine engine;

    public QueensFrame(QueensEngine engine) {
        this.engine = engine;
    }

    public void showFrame() {
        setTitle("Queens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(engine.getSize(), engine.getSize()));
        addFields();
        addMenu();
        pack();
        setVisible(true);
    }

    private void addFields() {
        for (int i = 0; i < engine.getSize(); ++i) {
            for (int j = 0; j < engine.getSize(); ++j) {
                addField(i, j);
            }
        }
    }
    
    private void addField(int i, int j) {
          JButton field = new JButton(); //JButton field = new JButton(Integer.toString(i) + j);
          field.setPreferredSize(new Dimension(65, 65));
          field.setFont(field.getFont().deriveFont(20.0f)); // fontot mi eddig hozzá volt rendelve lekéri és módosíthatom méretét
          field.setBackground(getBackgroundOfField(i, j));
          field.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  if (engine.put(i, j)) {
                  updateFields();
                      if (engine.hasWon()) {
                          if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(QueensFrame.this, PLAY_AGAIN, "You won", YES_NO_OPTION)) {
                              engine.startNewGame();
                              updateFields();
                          }
                      }
                  }
              }
          });
          getContentPane().add(field);
    }

    private Color getBackgroundOfField(int row, int column) {
        if (engine.isPaused()) {
            return Color.RED;
        }
        if (engine.isFree(row, column)) {
            return GREEN;
        } else {
            return row % 2 == column % 2 ? WHITE : GRAY;
        }
    }
    
    private void updateFields() {
        for (int i = 0; i < engine.getSize(); ++i) {
            for (int j = 0; j < engine.getSize(); ++j) {
                JButton field = (JButton) getComponent(i * engine.getSize() + j);
                field.setText(engine.isQueen(i,j) ? QUEEN : EMPTY);
            }
        }
    }
    
   /* private String getFieldText(int i, int j) {
        //
    }*/
    
    private void startNewGame() {
        engine.startNewGame();
        updateFields();
    }
    
    private void addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game:");
        menuBar.add(menu);
        menu.add(createNewGameMenuItem());
        menu.add(createUndoMenuItem());
        menu.add(createPauseMenuItem());
        setJMenuBar(menuBar);
    }

    private JMenuItem createNewGameMenuItem() {
        JMenuItem newGameMenuItem = new JMenuItem(RESTART);
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
        return newGameMenuItem;
    }

    private JMenuItem createUndoMenuItem() {
        JMenuItem undoMenuItem = new JMenuItem(UNDO);
        undoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.undo();
                updateFields();
            }
        });
        return undoMenuItem;
    }
    
    private JMenuItem createPauseMenuItem() {
        JMenuItem pauseMenuItem = new JMenuItem(PAUSE);
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                engine.togglePause();
                updateFields();
            }
        });
        return pauseMenuItem;
    }
}
