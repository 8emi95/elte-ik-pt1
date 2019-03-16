package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logic.Logic;
import logic.Player.PlayerType;

public class View extends JFrame {
    private final Logic logic = new Logic();
    private final int size = 8 ;
    private JButton buttons[][] = new JButton[size][size];
    
     public View(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size, size));
        
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                buttons[i][j]=addButton(mainPanel, i, j);
                if(i % 2 == j%2){
                    buttons[i][j].setBackground(Color.WHITE);
                }
                else{
                    buttons[i][j].setBackground(Color.BLACK);
                }
            }
        }
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        refresh();
     }
     
   public void refresh(){
       for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(logic.getTypeAt(i, j)!=null){
                    buttons[i][j].setText(logic.getTypeAt(i, j).name());
                    if(logic.getTypeAt(i, j)==PlayerType.VOLT) {
                        buttons[i][j].setBackground(Color.red);
                    }
                }else{
                    buttons[i][j].setText("");
                }
            }
        }
   }

    private JButton addButton(JPanel panel, final int i,
            final int j) {
        final JButton button = new JButton();
    button.addActionListener(new ActionListener() {
            //lépés után befrissíti a táblát és eldönti hogy volt e győztes
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.step(i, j);
                refresh();             
                
                PlayerType winner = logic.findWinner();
                if (winner != PlayerType.NOBODY) {
                    showGameOverMessage(winner);
                }
            }
        });

        panel.add(button);
        return button;
    }
        private void showGameOverMessage(PlayerType winner) {
        if (winner == PlayerType.VOLT){
            JOptionPane.showMessageDialog(this,
                    "Nem sikerült megnyerni a játékot");
        }else{
        JOptionPane.showMessageDialog(this,
            "Játék vége. Nyert: " + winner.name());
        }
    }
   
}
