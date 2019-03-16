import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/**
 * A párbeszédablakok kezelését végző osztály.
 * Egy keret, amelyből menüvel érhetjük el a különböző
 * párbeszédablakokat.
 */
public class Dialógusok extends JFrame
{
    /** az eseményke naplója */
    private JTextArea   info;

    /** színek */
    private Szín[]      színek = { new Szín("Fekete", Color.black), new Szín("Fehér", Color.white),
                                   new Szín("Szürke", Color.gray), new Szín("Piros", Color.red),
                                   new Szín("Zöld", Color.green), new Szín("Kék", Color.blue),
                                   new Szín("Sárga", Color.yellow), new Szín("Lila", Color.magenta),
                                   new Szín("Cián", Color.cyan) };

    /** Közös érték a csúszka és spinner demóhoz */
    private int         érték = 10;

    /** Csúszka demó elemei */
    private SliderDlg   csúszkadlg = new SliderDlg(this, "Csúszka", 0, 20, érték, 5);
    private AbstractAction  csúszka = new AbstractAction("Csúszka")
    {
        public void actionPerformed(ActionEvent e)
        {
            csúszkadlg.setValue(érték);
            csúszkadlg.setVisible(true);
            if ( csúszkadlg.getButtonCode() != OKCancelDialog.OK )  return;
            érték = csúszkadlg.getValue();
            info.append("Csúszka érték: " + érték + "\n");
        }
    };

    /** Gomb demó elemei */
    private boolean     inverz = false;
    private ButtonDlg   gombdlg = new ButtonDlg(this, "Háttérszín", színek, inverz);
    private AbstractAction  gombok = new AbstractAction("Gombok")
    {
        public void actionPerformed(ActionEvent e)
        {
            gombdlg.setValue(inverz);
            gombdlg.setVisible(true);
            if ( gombdlg.getButtonCode() != OKCancelDialog.OK ) return;
            if ( inverz = gombdlg.inverzmód() )
            {
                info.setBackground(ellentett(info.getForeground()));
                info.append("Inverz háttér\n");
            }
            else
            {
                info.setBackground(színek[gombdlg.szín()].szín());
                info.append("Háttér " + színek[gombdlg.szín()].név() + "\n");
            }
        }
    };

    /** Lista demó elemei */
    private ListDlg     listadlg = new ListDlg(this, "Szövegszín", színek);
    private AbstractAction  lista = new AbstractAction("Lista")
    {
        public void actionPerformed(ActionEvent e)
        {
            listadlg.setVisible(true);
            if ( listadlg.getButtonCode() != OKCancelDialog.OK )    return;
            Szín    sz = listadlg.getValue();
            info.setForeground(sz.szín());
            info.append("Szöveg " + sz.név() + "\n");
        }
    };

    /** Combobox demó elemei */
    private ComboDlg    combodlg = new ComboDlg(this, "Combo", színek);
    private AbstractAction  combo = new AbstractAction("Combobox")
    {
        public void actionPerformed(ActionEvent e)
        {
            combodlg.setVisible(true);
            if ( combodlg.getButtonCode() != OKCancelDialog.OK )    return;
            info.append("Combo: " + combodlg.getValue() + "\n");
        }
    };

    /** Combolista demó elemei */
    private ComboListDlg    combolistdlg = new ComboListDlg(this, "Combolista", színek);
    private AbstractAction  combolist = new AbstractAction("Combolista")
    {
        public void actionPerformed(ActionEvent e)
        {
            combolistdlg.setVisible(true);
            if ( combolistdlg.getButtonCode() != OKCancelDialog.OK )    return;
            info.append("Combolista: " + combolistdlg.getValue().név() + "\n");
        }
    };

    /** Szerkesztő demó elemei */
    private EditDlg     editdlg = new EditDlg(this, "Soreditor");
    private AbstractAction  edit = new AbstractAction("Sorszerkesztő")
    {
        public void actionPerformed(ActionEvent e)
        {
            editdlg.setVisible(true);
            if ( editdlg.getButtonCode() != OKCancelDialog.OK ) return;
            info.append("Sorszerkesztő: " + editdlg.getValue() + "\n");
        }
    };

    /** Spinner demó elemei */
    private SpinnerDlg  spinnerdlg = new SpinnerDlg(this, "Spinner", 0, 20, érték);
    private AbstractAction  spinner = new AbstractAction("Spinner")
    {
        public void actionPerformed(ActionEvent e)
        {
            spinnerdlg.setValue(érték);
            spinnerdlg.setVisible(true);
            if ( spinnerdlg.getButtonCode() != OKCancelDialog.OK )  return;
            érték = spinnerdlg.getValue();
            info.append("Spinner: " + érték + "\n");
        }
    };

    /** Táblázat demó elemei */
    private TáblázatDlg tábladlg = new TáblázatDlg(this, "Színek táblázata", színek);
    private AbstractAction  tábla = new AbstractAction("Táblázat")
    {
        public void actionPerformed(ActionEvent e)
        {
            tábladlg.setVisible(true);
        }
    };

    public Dialógusok()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar    menü = new JMenuBar();
        JMenu       dlg = new JMenu("Párbeszédablakok");
        dlg.setMnemonic('P');
        JMenuItem   item;
        item = dlg.add(csúszka);    item.setMnemonic('C');
        item = dlg.add(gombok);     item.setMnemonic('G');
        item = dlg.add(lista);      item.setMnemonic('L');
        item = dlg.add(combo);      item.setMnemonic('O');
        item = dlg.add(combolist);  item.setMnemonic('I');
        item = dlg.add(edit);       item.setMnemonic('E');
        item = dlg.add(spinner);    item.setMnemonic('S');
        item = dlg.add(tábla);      item.setMnemonic('T');
        menü.add(dlg);
        setJMenuBar(menü);
        info = new JTextArea();
        info.setForeground(színek[0].szín());
        add(new JScrollPane(info));
        setSize(300, 200);
        setVisible(true);
    }

    /** Egy szín inverzének meghatározása */
    private Color ellentett(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    public static void main(String[] args)
    {
        new Dialógusok();
    }
}
