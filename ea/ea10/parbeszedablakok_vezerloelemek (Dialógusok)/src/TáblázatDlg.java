import javax.swing.*;
import java.awt.*;
import javax.swing.table.AbstractTableModel;

/**
 * Táblázatok használatát szemléltető párveszédablak
 */
public class TáblázatDlg extends OKCancelDialog
{
    private JTable  táblázat;
    private Szín[]  színek;

    public TáblázatDlg(JFrame keret, String cím, Szín[] színek)
    {
        super(keret, cím);
        this.színek = színek;
        táblázat = new JTable(táblamodell);
        setLayout(new BorderLayout());
        add("Center", new JScrollPane(táblázat));
        add("South", gombpanel);
        setSize(400, 200);
        setResizable(true);
    }

    @Override
    protected boolean processOK()   { return true; }

    @Override
    protected void processCancel()  {}

    private AbstractTableModel  táblamodell = new AbstractTableModel()
    {
        private final String[]  nevek = { "Név", "Piros", "Zöld", "Kék" };

        public int getRowCount()    { return színek.length; }

        public int getColumnCount() { return nevek.length; }

        public Object getValueAt(int rowIndex, int columnIndex)
        {
            switch ( columnIndex )
            {
                case 0: return színek[rowIndex].név();
                case 1: return Integer.valueOf(színek[rowIndex].szín().getRed());
                case 2: return Integer.valueOf(színek[rowIndex].szín().getGreen());
                case 3: return Integer.valueOf(színek[rowIndex].szín().getBlue());
                default:
            }
            return null;
        }

        @Override
        public String getColumnName(int column)
        {
            return nevek[column];
        }
    };
}
