import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class FenyujsagPanel extends JPanel
    implements ActionListener, AdjustmentListener {
        private JLabel lbKesleltetes;
        private JScrollBar sbDelay;
        private JLabel lbSzoveg;
        private Timer idozito;
        
        public FenyujsagPanel(String text, int delay, Color foreground, Font font){
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
            lbKesleltetes = new JLabel(delay + "ms");
            lbKesleltetes.setPreferredSize(new Dimension(50, 16));
            lbKesleltetes.setHorizontalAlignment(JLabel.RIGHT);
            sbDelay = new JScrollBar(JScrollBar.HORIZONTAL, delay, 0, 0, 2000);
            sbDelay.setPreferredSize(new Dimension(150, 17));
            sbDelay.setUnitIncrement(100);
            sbDelay.setBlockIncrement(200);
            sbDelay.addAdjustmentListener(this);
            lbSzoveg = new JLabel(text + " ");
            lbSzoveg.setPreferredSize(new Dimension(400, 50));
            lbSzoveg.setForeground(foreground);
            lbSzoveg.setFont(font);
            add(lbKesleltetes);
            add(sbDelay);
            add(lbSzoveg);
            idozito = new Timer(delay, this);
            idozito.start();
        }
        
        public void actionPerformed(ActionEvent e) {
            String st = lbSzoveg.getText();
            st = st.substring(1)+ st.charAt(0);
            lbSzoveg.setText(st);
        }
        
        public void adjustmentValueChanged(AdjustmentEvent e){
            idozito.setDelay(e.getValue());
            lbKesleltetes.setText(e.getValue()+ " ms");
        }
    } 

