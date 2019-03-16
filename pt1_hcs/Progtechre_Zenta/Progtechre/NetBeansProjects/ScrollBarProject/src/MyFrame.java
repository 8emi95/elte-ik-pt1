import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements AdjustmentListener {

    static final int INITVALUE =500;
    JPanel pnVezerlo = new JPanel();
    JLabel lbKijelzo = new JLabel(""+INITVALUE);
    JScrollBar sbBeallito = new JScrollBar(JScrollBar.HORIZONTAL, INITVALUE, 0, 100, 1000);
    JButton btKilep = new JButton("Kilép");
    
    public MyFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 200);
        setTitle("JScrollBar teszt");
        getContentPane().setBackground(Color.BLUE);
        pnVezerlo.setBackground(Color.YELLOW);
        lbKijelzo.setForeground(Color.WHITE);
        lbKijelzo.setFont(new Font("Dialog", Font.BOLD, 40));
        lbKijelzo.setHorizontalAlignment(JLabel.CENTER);
        sbBeallito.setPreferredSize(new Dimension(200, 17));
        sbBeallito.setUnitIncrement(100);
        sbBeallito.setBlockIncrement(50);
        add(lbKijelzo); // a contentPane "Center poziciójába teszi
        add(pnVezerlo, "South");
        pnVezerlo.add(sbBeallito);
        pnVezerlo.add(btKilep);
        btKilep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        sbBeallito.addAdjustmentListener(this);
        setVisible(true);
    }
    
    public void adjustmentValueChanged(AdjustmentEvent e) {
        lbKijelzo.setText(""+e.getValue());
    }
            
    
    public static void main(String[] args) {
        new MyFrame();
    }
    
}
