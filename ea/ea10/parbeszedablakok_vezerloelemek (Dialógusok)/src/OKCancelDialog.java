import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * OK és Mégsem gombokkal rendelkező párbeszédablakok közös őse.
 */
public abstract class OKCancelDialog extends JDialog
{
    public static final int     OK = 1;     // OK gombbal történő lezárás kódja
    public static final int     CANCEL = 0; // Mégsem gombbal történő lezárás kódja

    protected int       gombkód;            // a megnyomott gomb kódja

    protected JPanel    gombpanel;          // az OK, Mégsem gombok elhelyezésére szolgáló panel

    protected JButton   okgomb;             // OK gomb

    protected JButton   mégsemgomb;         // Mégsem gomb

    /**
     * Egy párbeszédablak létrehozása
     * @param keret a keret, amihez a párbeszédablak tartozik
     * @param cím a párbeszédablak címe
     */
    protected OKCancelDialog(JFrame keret, String cím)
    {
        super(keret, cím, true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        gombkód = CANCEL;
        okgomb = new JButton(okakció);
        okgomb.setMnemonic('O');
        okgomb.setPreferredSize(new Dimension(90, 25));
        mégsemgomb = new JButton(mégsemakció);
        // Az Esc billentyű hozzárendelése a mégsem gombhoz (Esc lenyomása a párbeszédablakon belül -> mégsem gomb lenyomása
        KeyStroke mégsemKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        InputMap inputMap = mégsemgomb.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = mégsemgomb.getActionMap();
        if (inputMap != null && actionMap != null)
        {
            inputMap.put(mégsemKeyStroke, "cancel");
            actionMap.put("cancel", mégsemakció);
        }
        mégsemgomb.setPreferredSize(new Dimension(90, 25));
        getRootPane().setDefaultButton(okgomb);
        gombpanel = new JPanel(new FlowLayout());
        gombpanel.add(okgomb);
        gombpanel.add(mégsemgomb);
    }

    /**
     * Az ablak bezárását okozó gomb lekérdezése
     * @return a gomb kódja
     */
    public int getButtonCode()      { return gombkód; }

    /**
     * az OK megnyomásakor elvégzendő ellenőrzések, műveletek
     * @return true, ha a gomb lenyomása elfogadott
     */
    protected abstract boolean processOK();

    /**
     * a Cancel megnyomásakor elvégzendő tevékenységek
     */
    protected abstract void processCancel();

    /**
     * Az OK gomb eseménykezelője
     */
    private AbstractAction  okakció = new AbstractAction("OK")
    {
        public void actionPerformed(ActionEvent e)
        {
            if ( processOK() )
            {
                gombkód = OK;
                OKCancelDialog.this.setVisible(false);
            }
        }
    };

    /**
     * A Mégsem gomb esemény kezelője
     */
    private AbstractAction mégsemakció = new AbstractAction("Mégsem")
    {
        public void actionPerformed(ActionEvent e)
        {
            processCancel();
            gombkód = CANCEL;
            OKCancelDialog.this.setVisible(false);
        }
    };
}
