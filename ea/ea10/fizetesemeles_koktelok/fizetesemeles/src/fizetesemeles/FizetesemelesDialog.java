/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fizetesemeles;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Dobreff András
 */
public class FizetesemelesDialog extends OKCancelDialog{

    public FizetesemelesDialog(JFrame keret) {
        super(keret, "Fizetésemelés2");
        this.setSize(400, 125);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.add(this.gombpanel, BorderLayout.SOUTH);

        JLabel label = new JLabel("Meg van elégedve a fizetésével?");
        this.add(label);
        label.setHorizontalAlignment(JLabel.CENTER);
        this.okgomb.setText("Igen");
        this.mégsemgomb.setText("Nem");
        
        Random random = new Random();
        
        this.mégsemgomb.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                setLocation(random.nextInt(800), random.nextInt(600));
            }
        });
    }

    @Override
    protected boolean processOK() {
        dispose();
        return true;
    }

    @Override
    protected void processCancel() {
        System.err.println("Nem pressed");
        dispose();
    }
    
}
