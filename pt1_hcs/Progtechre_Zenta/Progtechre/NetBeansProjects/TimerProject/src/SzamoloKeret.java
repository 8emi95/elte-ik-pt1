import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SzamoloKeret extends JFrame implements ActionListener {

    private Timer idozito;
    private int szamlalo = 0;
    private JLabel lbFelirat = new JLabel("" + szamlalo);
    
    public SzamoloKeret() {
        idozito = new Timer(1000, this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 200);
        lbFelirat.setFont(new Font("Dialog", Font.BOLD, 50));
        lbFelirat.setForeground(Color.BLUE);
        lbFelirat.setHorizontalAlignment(JLabel.CENTER);
        add(lbFelirat);
        setVisible(true);
        idozito.start();
    }
    
    public void actionPerformed(ActionEvent e) {
        lbFelirat.setText("" + ++szamlalo);
    }
    
    public static void main(String[] args) {
        new SzamoloKeret();
    }
    
}
