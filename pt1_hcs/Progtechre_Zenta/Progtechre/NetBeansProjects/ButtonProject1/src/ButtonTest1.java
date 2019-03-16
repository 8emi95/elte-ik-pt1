import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
class SzinvalasztFrame extends JFrame implements ActionListener{ //eseményfigyelő
    
    Container cp = getContentPane();
    JButton btPiros, btFeher, btZold, btKilep;
    JPanel pnSzin;
    JLabel lbSzoveg;
    
    public SzinvalasztFrame() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Szinvalasztas");
        cp.add(pnSzin = new JPanel(),"North");
        pnSzin.setBackground(Color.RED);
        lbSzoveg = new JLabel(" Válassz színt!");
        lbSzoveg.setBackground(Color.WHITE);
        lbSzoveg.setOpaque(true);
        lbSzoveg.setBorder(BorderFactory.createRaisedBevelBorder());
        pnSzin.add(lbSzoveg);
        
        JPanel pnGombok = new JPanel();
        pnGombok.add(btPiros = new JButton("Piros"));
        pnGombok.add(btFeher = new JButton("Fehér"));
        pnGombok.add(btZold = new JButton("Zöld"));
        pnGombok.add(btKilep = new JButton("Kilép"));
        cp.add(pnGombok, "South");
        
        btPiros.addActionListener(this);
        btFeher.addActionListener(this);
        btZold.addActionListener(this);
        btKilep.addActionListener(this);
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btPiros)
            pnSzin.setBackground(Color.RED);            
        if (e.getSource() == btFeher)
            pnSzin.setBackground(Color.WHITE);  
        if (e.getSource() == btZold)
            pnSzin.setBackground(Color.GREEN);  
        if (e.getSource() == btKilep)
            System.exit(0);
    }
}
    
public class ButtonTest1 {
    public static void main(String[] args){
        new SzinvalasztFrame();
    }
}

