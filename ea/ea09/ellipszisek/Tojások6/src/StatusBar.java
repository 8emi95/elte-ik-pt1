import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class StatusBar extends JPanel
{
    private JLabel[]    cellák;         // a státuszsor elemei, cellái
    private int         cellamagasság;  // a státuszsor celláinak magassága

    /**
     * Létrehoz egy státuszsort
     * @param cellaszám a státuszsorban szereplő cellák száma (min. 1)
     */
    public StatusBar(int cellaszám)
    {
        cellaszám = Math.max(1, cellaszám);
        cellamagasság = 16;
        cellák = new JLabel[cellaszám];
        GridBagLayout		layout = new GridBagLayout();
        GridBagConstraints	cs = new GridBagConstraints();
        cs.fill = GridBagConstraints.HORIZONTAL;
        cs.anchor = GridBagConstraints.WEST;
        cs.gridwidth = 1;
        cs.gridheight = 1;
        cs.gridx = GridBagConstraints.RELATIVE;
        cs.gridy = 0;
        cs.ipadx = cs.ipady = 0;
        cs.weighty = 0.0;
        cs.weightx = 1.0;	// ez szélesedhet automatikusan
        cs.insets = new Insets(2, 0, 0, 0);	// margó felül
        cellák[0] = new JLabel();
        cellák[0].setBorder(cellakeret);
        add(cellák[0]);
        layout.addLayoutComponent(cellák[0], cs);
        cs.weightx = 0.0;	// nem nőhet a szélessége
        for ( int i = 1; i < cellaszám; i++ )
        {
            cellák[i] = new JLabel();
            cellák[i].setBorder(cellakeret);
            add(cellák[i]);
            layout.addLayoutComponent(cellák[i], cs);
        }
        setLayout(layout);
    }

    /**
     * Adott cella feliratának állítása
     * @param index a cella indexe (0-val kezdődik)
     * @param text a cella felirata
     */
    public void setText(int index, String text)
    {
        cellák[index].setText(text);
    }

    /**
     * A cellák magasságának állítása
     * @param height az összes cella új magassága
     */
    public void setHeight(int height)
    {
        cellamagasság = Math.max(10, height);
        for ( int i = 0; i < cellák.length; i++ )
        {
            Dimension   d = cellák[i].getPreferredSize();
            d.height = cellamagasság;
            cellák[i].setPreferredSize(d);
        }
    }

    /**
     * Adott cella szélességének állítása
     * @param index a cella indexe (0-val kezdődik)
     * @param width a cella szélessége
     */
    public void setWidth(int index, int width)
    {
        cellák[index].setPreferredSize(new Dimension(width, cellamagasság));
    }

    /** Cellák kerete; Border interfész megvalósítása */
    private Border  cellakeret = new Border()
    {
        private final Color     szürke = new Color(144, 144, 144);
        private final Insets    insets = new Insets(0, 6, 2, 6);    // keret margói

        /** keret kirajzolása */
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
        {
            Color   régi = g.getColor();
            g.translate(x, y);
            g.setColor(szürke);
            g.drawLine(0, 0, 0, height - 1);
	        g.drawLine(1, 0, width - 1, 0);
            g.setColor(Color.white);
	        g.drawLine(1, height - 1, width - 1, height - 1);
	        g.drawLine(width - 1, 1, width - 1, height - 2);
            g.translate(-x, -y);
            g.setColor(régi);
        }

        /** keret margói */
        public Insets getBorderInsets(Component c)  { return insets; }

        /** átlátszó-e a keret: nem */
        public boolean isBorderOpaque()             { return false; }
    };
}
