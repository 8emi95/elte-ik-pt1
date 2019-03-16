import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Gombok kezelését bemutató párbeszédablak
 */
public class ButtonDlg extends OKCancelDialog
{
    private JCheckBox       inverz;
    private JRadioButton[]  színgombok;
    private int             jelölt;

    /**
     * Egy párbeszédablak létrehozása
     * @param keret ehhez tartozik a dialógus
     * @param cím a fejléc tartalma
     * @param színek a választható színek
     * @param inv a szövegszín inverzét választjuk-e
     */
    public ButtonDlg(JFrame keret, String cím, Szín[] színek, boolean inv)
    {
        super(keret, cím);
        inverz = new JCheckBox("Szövegszín inverze", inv);
        ButtonGroup csoport = new ButtonGroup();
        JPanel      színpanel = new JPanel(new GridLayout(színek.length / 3, 3));
        színpanel.setBorder(new TitledBorder(new EtchedBorder(), "Háttérszín: "));
        színgombok = new JRadioButton[színek.length];
        for ( int i = 0; i < színek.length; i++ )
        {
            színgombok[i] = gomb(színek[i]);
            színpanel.add(színgombok[i]);
            csoport.add(színgombok[i]);
        }
        setLayout(new BorderLayout());
        add("North", inverz);
        add("Center", színpanel);
        add("South", gombpanel);

        pack();
        setResizable(false);
    }

    /**
     * Beállítja a checkbox és a rádiógombok értékét
     * @param inv inverz mód-e (checkbox)
     */
    public void setValue(boolean inv)
    {
        inverz.setSelected(inv);
    }

    /**
     * Iverzmód lekérdezése
     * @return igaz, ha inverz módot írtunk elő, hamis különben
     */
    public boolean inverzmód()          { return inverz.isSelected(); }

    /**
     * A kiválasztott szín indexének lekérdezése
     * @return az index
     */
    public int szín()                   { return jelölt; }

    @Override
    protected boolean processOK()
    {
        if ( inverz.isSelected() )  return true;
        for ( int i = 0; i < színgombok.length; i++ )
            if ( színgombok[i].isSelected() )
            {
                jelölt = i;
                return true;
            }
        return false;
    }

    @Override
    protected void processCancel()      {}

    /**
     * Egy színnek megfelelő rádiógomb létrehozása
     * @param sz a szín
     * @return rádiógomb
     */
    private JRadioButton gomb(Szín sz)
    {
        BufferedImage   img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics        g = img.getGraphics();
        g.setColor(sz.szín());
        g.fillOval(0, 0, 16, 16);
        JRadioButton    b = new JRadioButton(sz.név(), new ImageIcon(img));
        img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        g = img.getGraphics();
        g.setColor(sz.szín());
        g.fillOval(0, 0, 16, 16);
        if ( sz.szín().equals(Color.black) )    g.setColor(Color.white);
        else                                    g.setColor(Color.black);
        g.fillOval(4, 4, 8, 8);
        b.setSelectedIcon(new ImageIcon(img));
        return b;
    }
}
