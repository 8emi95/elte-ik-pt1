package vadasz_beadando;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author zentaidavid
 */
/*
northPanel: a Felső 3 gomb (hányszor hanyas legyen a tábla)
centerPanel: a játéktér
actualPlayerLabel: az aktuális játékost tartalmazó felirat
counterLabel: visszaszámláló a lépésekből
three,five,seven: a játéktábla méreteit megadó gombok
base: a játék "logikáját" tartalmazó tábla
highlighted: kiemelt gomb
refToButtons[][]: a többi gomb referenciája i és j szerint
*/
public class GameWindow extends JFrame implements ActionListener {
    
    JPanel northPanel = new JPanel();   
    JPanel centerPanel = new JPanel();
    JLabel actualPlayerLabel = new JLabel();
    JLabel counterLabel = new JLabel();
    JButton three = new JButton();
    JButton five = new JButton();
    JButton seven = new JButton();
    GameBase base;
    JButton[][] refToButtons;
    MyVector highlighted;
    /*
    Magának a játék ablaknak a meghívása. És az ablak paramétereinek a megadása.
    */
    public GameWindow(int size){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        refToButtons = new JButton[size][size];
        highlighted = new MyVector(-1,-1);
        actualPlayerLabel = new JLabel("Aktuális játékos: Vadász");
        northPanel.setLayout(new GridLayout(1,3));
        
        three.setText("3x3-as");
        three.addActionListener(this);
        northPanel.add(three);
        
        five.setText("5x5-ös");
        five.addActionListener(this);
        northPanel.add(five);
        
        seven.setText("7x7-es");
        seven.addActionListener(this);
        northPanel.add(seven);
        
        northPanel.add(actualPlayerLabel);
        northPanel.add(counterLabel);
        
        centerPanel.setLayout(new GridLayout(size,size));
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                addButton(i,j,centerPanel);
            }
        }
        base = new GameBase(size);
        counterLabel.setText("Hátralévő lépések:" + base.getStepCount());
        
        repaintButtons();
        
        setSize(800,800);
        getContentPane().add(northPanel,BorderLayout.NORTH);
        getContentPane().add(centerPanel,BorderLayout.CENTER);
        setVisible(true);
    }
    /*
    A játéktábla vezérlője, ez veszi fel a gombokat, írja át a Labelt, jelzi ki 
    a játék végét.
    */
    public void addButton(int i, int j, JPanel panel){
        JButton button = new JButton();
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(highlighted.getX() == -1 && highlighted.getY() == -1 
                   && base.getGameTable()[i][j] != Player.NOBODY  
                   &&base.getGameTable()[i][j] == base.getActualPlayer()){
                    highlighted.setX(i);
                    highlighted.setY(j);
                } else if(highlighted.getX() != -1 && highlighted.getY() != -1
                          && base.getGameTable()[highlighted.getX()][highlighted.getY()] == 
                          base.getActualPlayer()){
                    base.MakeStep(i,j,highlighted);
                    counterLabel.setText("Hátralévő lépések:" + base.getStepCount());
                    setActualPlayerLabel();
                    if(base.isStepMade()){
                        highlighted.setX(-1);
                        highlighted.setY(-1);
                    }
                } else if (highlighted.getX() != -1 && highlighted.getY() != -1
                        && base.getGameTable()[highlighted.getX()][highlighted.getY()] == base.getActualPlayer()
                        && base.getGameTable()[highlighted.getX()][highlighted.getY()] == base.getGameTable()[i][j]) {
                    highlighted.setX(-1);
                    highlighted.setY(-1);
                }
                if(base.isGameOver()){
                    gameOver();
                }
                repaintButtons();
            }
        });
        refToButtons[i][j] = button;
        panel.add(button);
    }
    /*
    Ha a játékos lépett akkor a többi mezőt átrakja SENKI-jére hogy lehessen rájuk
    újra lépni.
    */
    public void repaintButtons(){
        Player[][] gameTable = base.getGameTable();
        for(int i =0; i < gameTable.length; i++){
            for(int j = 0; j < gameTable.length; j++){
                if(gameTable[i][j] != Player.NOBODY){
                    refToButtons[i][j].setText(gameTable[i][j] + "");
                } else {
                    refToButtons[i][j].setText("");
                }
            }
        }
    }
    /*
    A játéktábla méretét állítja be. 3x3,5x5,7x7
    */
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == three){
            newGame(3);
        } else if(ae.getSource() == five){
            newGame(5);
        } else if(ae.getSource() == seven){
            newGame(7);
        }
    }
    /*
    Új játék kezdetekor új táblát készít.
    */        
    private void newGame(int size){
        dispose();  //bezárja a felesleges lapokat
        new GameWindow(size);
    }
    /*
    Ha végetért a játék akkor új 3x3 táblát hoz létre és kiírja a nyertest.
    */
    private void gameOver(){
        newGame(3);
        if(base.getStepCount()== 0)JOptionPane.showMessageDialog(this,"A játékot a menekülő nyerte!");
        else JOptionPane.showMessageDialog(this,"A játékot a vadász nyerte!");
    }
    /*
    Beállítja az aktuális játékosnak megfelelően a feliratot felül
    */
    private void setActualPlayerLabel(){
        if(base.getActualPlayer() == Player.HUNTED){
            actualPlayerLabel.setText("Az aktuális játékos: Menekülő");
        }else if(base.getActualPlayer() == Player.HUNTER){
            actualPlayerLabel.setText("Az aktuális játékos: Vadász");
        }
    }
}