package pegsolitaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PegSolitaireFrame extends JFrame{
    private PegSolitaireLogic logic;
    private JPanel gamePanel;
    private int gb1_posX;
    private int gb1_posY;
    private int gb2_posX;
    private int gb2_posY;
    private GameButton prevB;
    public PegSolitaireFrame(PegSolitaireLogic logic){
        this.logic = logic;
        setTitle("Peg Solitaire");
        setLocation(50,26);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        gamePanel = new JPanel();
        int width = logic.getWidth();
        int height = logic.getHeight();
        
        gamePanel.setLayout(new GridLayout(width,height) );
        for (int j = 0; j < height; j++){
            for (int i = 0; i < width; i++) {
                JButton jButton = new GameButton(i,j);
                jButton.setPreferredSize(new Dimension(100,100));
                if(logic.isPegExisting(i, j)){
                    jButton.addActionListener(buttonActionListener);
                    jButton.setBorder(new LineBorder(Color.GRAY));
                }else{
                    jButton.setVisible(false);
                } 
                gamePanel.add(jButton);
            }
        }
        add(gamePanel,BorderLayout.CENTER);
        setButtonColors();
        
        add(new JButton(newGameAction),BorderLayout.NORTH);
        
        pack();        
    }
   
    private ActionListener buttonActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if((gb1_posX != 0 || gb1_posY != 0) && (gb2_posX != 0 || gb2_posY != 0)){
                setNullVariable();
                
            }
            GameButton source = (GameButton) e.getSource();
            int posX = source.getPosX();
            int posY = source.getPosY();
            
            source.setBorder(new LineBorder(Color.YELLOW));
            if(gb1_posX == 0 && gb1_posY == 0){
                gb1_posX = posX;
                gb1_posY = posY;
                prevB = source;                
            } else {
                gb2_posX = posX;
                gb2_posY = posY;            
                doAction(gb1_posX,gb1_posY, gb2_posX, gb2_posY);
                source.setBorder(new LineBorder(Color.GRAY));
                prevB.setBorder(new LineBorder(Color.GRAY));
            }
            
            
        }
    };
    
    private void doAction(int g1X,int g1Y, int g2X, int g2Y){
        logic.doPegJump(g1X, g1Y, g2X, g2Y);
        setButtonColors();
    }
    
    private Action newGameAction = new AbstractAction("Új játék") {

        @Override
        public void actionPerformed(ActionEvent e) {
            logic.newGame();
            setButtonColors();
        }
    };
    
    private void setButtonColors() {
        for (Component component : gamePanel.getComponents()) {
             GameButton source = (GameButton) component;
             int posX = source.getPosX();
             int posY = source.getPosY();
             
             Color color; 
             if(logic.hasPeg(posX, posY)){
                 color = Color.BLACK;          
             } else {
                 color = Color.RED;
             }
             source.setBackground(color);
        }
        boolean isGameWon = logic.isGameWon();
        if(isGameWon){
            JOptionPane.showMessageDialog(this, "Nyertél :)");
            logic.newGame();
            setNullVariable();
            setButtonColors();
        }
    }    
    private void setNullVariable() {
        gb1_posX = 0;
        gb1_posY = 0;
        gb2_posX = 0;
        gb2_posY = 0;
    }
}
