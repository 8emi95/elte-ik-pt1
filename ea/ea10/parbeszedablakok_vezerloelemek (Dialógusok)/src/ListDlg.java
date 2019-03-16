import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Lista kezelését bemutató párbeszédablak
 */
public class ListDlg extends OKCancelDialog
{
    private JList   lista;

    public ListDlg(JFrame keret, String cím, Szín[] színek)
    {
        super(keret, cím);
        lista = new JList(színek);
        lista.addMouseListener(egér);
        lista.setCellRenderer(elemforma);
        setLayout(new BorderLayout());
        add("Center", new JScrollPane(lista));
        add("South", gombpanel);

        pack();
        setResizable(false);
    }

    /** A kiválasztott szín lekérdezése */
    public Szín getValue()          { return (Szín)lista.getSelectedValue(); }

    @Override
    protected boolean processOK()   { return lista.getSelectedIndex() > -1; }

    @Override
    protected void processCancel()  {}

    /** Dupla kattintás kezelése a listán */
    private MouseListener   egér = new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if ( e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 )
                okgomb.doClick();
        }
    };

    /** Egy listaelem kinézetének megadása */
    private DefaultListCellRenderer elemforma = new DefaultListCellRenderer()
    {
        @Override
        public Component getListCellRendererComponent(JList l, Object o, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus)
        {
            super.getListCellRendererComponent(l, o, index, isSelected, cellHasFocus);
            BufferedImage   im = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
            Graphics        g = im.createGraphics();
            g.setColor(((Szín)o).szín());
            g.fillRect(0, 0, 16, 16);
            setIcon(new ImageIcon(im));
            return this;
	    }
    };
}
