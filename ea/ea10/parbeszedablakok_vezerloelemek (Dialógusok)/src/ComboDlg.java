import javax.swing.*;
import java.awt.*;

/**
 * Combobox kezelését bemutató párbeszédablak
 */
public class ComboDlg extends OKCancelDialog
{
    private JComboBox   combo;

    public ComboDlg(JFrame keret, String cím, Szín[] színek)
    {
        super(keret, cím);
        combo = new JComboBox();
        for ( int i = 0; i < színek.length; i++ )
            combo.addItem(színek[i].név());
        combo.setEditable(true);
        setLayout(new BorderLayout());
        add("Center", combo);
        add("South", gombpanel);
        pack();
        setResizable(false);
    }

    /** Érték lekérdezése */
    public String getValue()        { return (String)combo.getEditor().getItem(); }
    
    @Override
    protected boolean processOK()   { return true; }

    @Override
    protected void processCancel()  {}
}
