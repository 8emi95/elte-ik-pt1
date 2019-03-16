package szamlalo;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class SzámlálóGomb extends JButton implements ActionListener
{
    private ÜresKeret üresKeret;
    
    public SzámlálóGomb(ÜresKeret üresKeret)
    {
        this.üresKeret = üresKeret;
        setText("Kattintás");
        addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        üresKeret.SzámlálóNövelés();
    }
}
