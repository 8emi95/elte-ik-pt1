import java.awt.*;
import javax.swing.*;

// Rajzterület, amelyre a tojások kerülnek
public class RajzPanel extends JPanel
{
    private int     méret;      // a legnagyobb tojás mérete

    public RajzPanel(int méret)
    {
        this.méret = méret;
    }

    public void méretváltás(int mérték)
    {
        méret += mérték;
        if ( méret < 0 )    méret = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, getWidth(), getHeight());
        int     tető = 0;
        for ( int m = méret; m > 0; m -= 30 )   tető += rajzol(g, tető, m);
    }

    private int rajzol(Graphics g, int t, int m)
    {
        int     magasság = (2 * m) / 3;
        int     bal = (getWidth() - m) / 2;
        g.setColor(Color.gray);
        g.fillOval(bal, t, m, magasság);
        g.setColor(Color.black);
        g.drawOval(bal, t, m, magasság);
        return magasság;
    }
}
