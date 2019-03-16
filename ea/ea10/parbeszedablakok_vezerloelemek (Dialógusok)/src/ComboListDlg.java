import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Combobox lista kezelését bemutató párbeszédablak
 */
public class ComboListDlg extends OKCancelDialog
{
    private JComboBox   combo;

    public ComboListDlg(JFrame keret, String cím, Szín[] színek)
    {
        super(keret, cím);
        combo = new JComboBox(színek);
        combo.setRenderer(elemforma);
        setLayout(new BorderLayout());
        add("Center", combo);
        add("South", gombpanel);
        pack();
        setResizable(false);
    }

    /** A kiválasztott elem (szín) lekérdezése */
    public Szín getValue()          { return (Szín)combo.getSelectedItem(); }

    @Override
    protected boolean processOK()   { return true; }

    @Override
    protected void processCancel()  {}

    /** Az elemek megjelenítésének szabályozása */
    private DefaultListCellRenderer elemforma = new DefaultListCellRenderer()
    {
        @Override
        public Component getListCellRendererComponent(JList l, Object o, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus)
        {
            super.getListCellRendererComponent(l, o, index, isSelected, cellHasFocus);
            BufferedImage   im = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Graphics        g = im.createGraphics();
            g.setColor(((Szín)o).szín());
            g.fillOval(0, 0, 15, 15);
            setIcon(new ImageIcon(im));
            return this;
	    }
    };
}
