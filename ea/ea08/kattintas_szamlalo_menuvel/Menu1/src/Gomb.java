import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Toolkit;

public class Gomb extends JFrame
{
    public static void main(String[] args)
    {
        new Gomb();
    }

    private int     érték;
    private JLabel  felirat;

    public Gomb()
    {
        addWindowListener(kilépés);
        setJMenuBar(menusor());
        setLayout(new BorderLayout());
        JPanel  gombok = new JPanel(new FlowLayout());
        érték = 0;
        felirat = new JLabel("Kattintások száma: 0");
        gombok.add(new JButton(kattintásakció));
        gombok.add(new JButton(kilépésakció));
        add("Center", felirat);
        add("South", gombok);
        java.net.URL    url = Gomb.class.getResource("gomb.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Számláló");
        pack();
        setVisible(true);
    }

	private JMenuBar menusor()
	{
		JMenuBar    menü = new JMenuBar();
		JMenu       tevékenységek = new JMenu("Tevékenységek");
		JMenuItem   nulláz = new JMenuItem(nullázás);
		nulláz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, Event.CTRL_MASK));
		nulláz.setMnemonic('N');
		JMenuItem   kilép = new JMenuItem(kilépésakció);
		kilép.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK));
		kilép.setMnemonic('K');
		tevékenységek.setMnemonic('T');
		tevékenységek.add(nulláz);
		tevékenységek.addSeparator();
		tevékenységek.add(kilép);
		menü.add(tevékenységek);
		return menü;
	}

    private void kilép()
    {
        System.exit(0);
    }

    private WindowAdapter   kilépés = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            kilép();
        }
    };

    private AbstractAction  kilépésakció = new AbstractAction("Kilépés")
    {
        public void actionPerformed(ActionEvent e)
        {
            kilép();
        }
    };

    private AbstractAction  kattintásakció = new AbstractAction("Kattintás")
    {
        public void actionPerformed(ActionEvent e)
        {
            érték++;
            felirat.setText("Kattintások száma: " + érték);
        }
    };

	private AbstractAction nullázás = new AbstractAction("Nullázás")
	{
        public void actionPerformed(ActionEvent e)
        {
            érték = 0;
            felirat.setText("Kattintások száma: 0");
        }
    };
}
