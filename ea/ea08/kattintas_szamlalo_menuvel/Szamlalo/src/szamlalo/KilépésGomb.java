package szamlalo;
import java.awt.event.*;
import javax.swing.*;

public class KilépésGomb extends JButton
{
    public KilépésGomb()
    {
        super(new AbstractAction("Kilépés") 
        {          
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new Kilépés().windowClosing(null); // System.exit(0);
            }
        });
    }
}

