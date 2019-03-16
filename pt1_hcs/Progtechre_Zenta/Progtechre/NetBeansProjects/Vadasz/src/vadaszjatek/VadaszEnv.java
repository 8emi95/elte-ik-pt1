/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszjatek;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Dávid
 */
public class VadaszEnv extends JFrame implements ActionListener{
    
    JMenuBar menu = new JMenuBar(); //menu és elemei
    JPanel pLabel = new JPanel();
    JPanel pJatekTer = new JPanel();
    JMenu mMeret = new JMenu("Méret");
    JMenuItem miHaromsz = new JMenuItem("3x3");
    JMenuItem miOtsz = new JMenuItem("5x5");
    JMenuItem miHetsz = new JMenuItem("7x7");
    JLabel lAktualis = new JLabel();
    JLabel lLepesek = new JLabel();
    JatekosPozik highlighted;
    VadaszEngine eng;
        int size = 3;
    
    public VadaszEnv(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,300,800,800);
        highlighted = new JatekosPozik(-1,-1);
        setTitle("Vadász társasjáték");
        
        setJMenuBar(menu);
        menu.add(mMeret);
        mMeret.add(miHaromsz);
        mMeret.add(miOtsz);
        mMeret.add(miHetsz);
        
        pLabel.setLayout(new GridLayout(1,1));
        pLabel.add(lAktualis);
        pLabel.add(lLepesek);
        
        pJatekTer.setLayout(new GridLayout(size, size));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gombLetrehoz(i,j,pJatekTer);
            }
        }
        
        eng = new VadaszEngine(size);
        lLepesek.setText("Lepesek: " + eng.getAktualis());
        
        Frissit();
        
        setSize(800,800);
        getContentPane().add(pLabel,BorderLayout.NORTH);
        getContentPane().add(pJatekTer,BorderLayout.CENTER);
        setVisible(true);
    }
  
    public void actionperformed (ActionEvent e){
        if( e.getSource() == miHaromsz ) {
            size=3;
        }
        else if( e.getSource() == miOtsz ){
            size=5;
        }
        else if( e.getSource() == miHetsz ){
            size=7;
        }
    }

    private void gombLetrehoz(int i, int j, JPanel pJatekTer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Frissit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
