package szamlalo;
import java.awt.event.*;

public class Kilépés extends WindowAdapter
{
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}

