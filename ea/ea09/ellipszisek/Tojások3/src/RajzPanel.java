import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// Rajzterület, amelyre a tojások kerülnek
public class RajzPanel extends JPanel
{
    private int                 méret;  // a legnagyobb tojás mérete
    private Ellipse2D.Double    e;      // a tojás rjzolásához használt ellipszis

    public RajzPanel(int méret)
    {
        this.méret = méret;
        e = new Ellipse2D.Double();
    }

    public void méretváltás(int mérték)
    {
        méret += mérték;
        if ( méret < 0 )    méret = 0;
        repaint();
    }

    public int maxMéret()       { return méret; }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect(0, 0, getWidth(), getHeight());
        int     tető = 0;
        for ( int m = méret; m > 0; m -= 30 )
            tető += rajzol((Graphics2D)g, tető, m);
    }

    private int rajzol(Graphics2D g, int t, int m)
    {
        int     magasság = (2 * m) / 3;
        int     bal = (getWidth() - m) / 2;
        e.setFrame(bal, t, m, magasság);
        g.setColor(Color.gray);
        g.fill(e);
        g.setColor(Color.black);
        g.draw(e);
        return magasság;
    }
}
