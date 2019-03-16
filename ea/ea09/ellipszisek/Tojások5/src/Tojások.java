import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tojások extends JFrame
{
    private int         változás = 30;  // méretváltozás mértéke

    private RajzPanel   rajz;           // a tojások megjelenítési helye

    private StatusBar   státuszsor;

    private AbstractAction  növelés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(változás);
            státuszsor.setText(0, "Legnagyobb tojás: " + rajz.maxMéret());
        }
    };

    private AbstractAction  csökkenés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(-változás);
            státuszsor.setText(0, "Legnagyobb tojás: " + rajz.maxMéret());
        }
    };

    private AbstractAction  változásállítás = new AbstractAction("Változás mértéke")
    {
        public void actionPerformed(ActionEvent e)
        {
            String  str = JOptionPane.showInputDialog("Változás mértéke:");
            if ( str == null )  return;
            try
            {
                változás = Integer.parseInt(str);
                státuszsor.setText(1, "Változás: " + változás);
            }
            catch (Exception ex) {}
        }
    };

    private AbstractAction  kilépés = new AbstractAction("Kilépés")
    {
        public void actionPerformed(ActionEvent e)  { kilép(); }
    };

    private WindowAdapter   kilépésvezérlő = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)    { kilép(); }
    };

    private void kilép()    { System.exit(0); }

    private boolean töltött;
    private JCheckBoxMenuItem   kitöltött;
    private JCheckBox           kitöltött_tool;

    private int     választott;
    private static final Color[]    töltőszínek = { Color.gray, Color.white, Color.green };
    private static final String[]   színnevek = { "Szürke", "Fehér", "Zöld" };
    private JRadioButtonMenuItem[]  szín;
    private JRadioButton[]      szín_tool;

    private AbstractAction  kitöltés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            töltött = !töltött;
            if ( töltött )  rajz.tölt(töltőszínek[választott]);
            else            rajz.tölt(null);
            kitöltött.setSelected(töltött);
            kitöltött_tool.setSelected(töltött);
        }
    };

    private AbstractAction  színező = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            Object  src = e.getSource();
            for ( int i = 0; i < szín.length; i++ )
                if ( src == szín[i] )
                {
                    if ( töltött )  rajz.tölt(töltőszínek[i]);
                    választott = i;
                    szín_tool[i].setSelected(true);
                    return;
                }
            for ( int i = 0; i < szín_tool.length; i++ )
                if ( src == szín_tool[i] )
                {
                    if ( töltött )  rajz.tölt(töltőszínek[i]);
                    választott = i;
                    szín[i].setSelected(true);
                    return;
                }
        }
    };

    public Tojások()
    {
        töltött = true;
        választott = 0;

        JMenuBar    menü = new JMenuBar();
        JMenu       tevékenységek = new JMenu("Tevékenységek");
        JMenuItem   növel = new JMenuItem(növelés);
        JMenuItem   csökkent = new JMenuItem(csökkenés);
        JMenuItem   változtat = new JMenuItem(változásállítás);
        JMenuItem   kilép = new JMenuItem(kilépés);
        JMenu       attribútumok = new JMenu("Attribútumok");
        kitöltött = new JCheckBoxMenuItem(kitöltés);
        ButtonGroup színek = new ButtonGroup();
        szín = new JRadioButtonMenuItem[töltőszínek.length];

        növel.setText("Növelés");
        növel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, Event.CTRL_MASK));
        növel.setMnemonic('N');
        csökkent.setText("Csökkentés");
        csökkent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, Event.CTRL_MASK));
        csökkent.setMnemonic('C');
        változtat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
        változtat.setMnemonic('V');
        kilép.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK));
        kilép.setMnemonic('K');
        tevékenységek.setMnemonic('T');

        tevékenységek.add(növel);
        tevékenységek.add(csökkent);
        tevékenységek.addSeparator();
        tevékenységek.add(változtat);
        tevékenységek.addSeparator();
        tevékenységek.add(kilép);
        menü.add(tevékenységek);

        kitöltött.setText("Kitöltött");
        kitöltött.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
        kitöltött.setMnemonic('K');
        attribútumok.add(kitöltött);
        attribútumok.setMnemonic('A');
        attribútumok.addSeparator();
        for ( int i = 0; i < töltőszínek.length; i++ )
        {
            szín[i] = new JRadioButtonMenuItem(színező);
            szín[i].setText(színnevek[i]);
            szín[i].setMnemonic(színnevek[i].charAt(0));
            attribútumok.add(szín[i]);  színek.add(szín[i]);
        }
        szín[0].setSelected(true);
        menü.add(attribútumok);

        státuszsor = new StatusBar(2);
        státuszsor.setText(0, "Legnagyobb tojás: 140");
        státuszsor.setText(1, "Változás: 30");
        státuszsor.setWidth(0, 100);
        státuszsor.setWidth(1, 100);

        setJMenuBar(menü);
        setSize(400, 300);
        setLayout(new BorderLayout());
        rajz = new RajzPanel(140);
        add("North", eszköztár());
        add("Center", new JScrollPane(rajz));
        add("South", státuszsor);
        addWindowListener(kilépésvezérlő);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Tojások.class.getResource("tojás.png")));
        setTitle("Tojások");
        setVisible(true);
    }

	private JToolBar eszköztár()
	{
		JToolBar	bar = new JToolBar();
		JButton		b;
		b = bar.add(növelés);
		b.setIcon(new ImageIcon(Tojások.class.getResource("növel.png")));
		b.setToolTipText("Növelés");
		b = bar.add(csökkenés);
		b.setIcon(new ImageIcon(Tojások.class.getResource("csökkent.png")));
		b.setToolTipText("Csökkentés");
        bar.addSeparator();
        kitöltött_tool = new JCheckBox(kitöltés);
        bar.add(kitöltött_tool);
        kitöltött_tool.setIcon(new ImageIcon(Tojások.class.getResource("üres.png")));
        kitöltött_tool.setSelectedIcon(new ImageIcon(Tojások.class.getResource("töltött.png")));
        kitöltött_tool.setSelected(töltött);
        kitöltött_tool.setToolTipText("Töltött/Üres");
        bar.addSeparator();
        ButtonGroup színek = new ButtonGroup();
        szín_tool = new JRadioButton[töltőszínek.length];
        for ( int i = 0; i < töltőszínek.length; i++ )
        {
            szín_tool[i] = new JRadioButton(színező);
            szín_tool[i].setIcon(ikon(i));
            szín_tool[i].setSelectedIcon(jelöltikon(i));
            szín_tool[i].setToolTipText(színnevek[i]);
            bar.add(szín_tool[i]);  színek.add(szín_tool[i]);
        }
        szín_tool[0].setSelected(true);
		return bar;
	}

    private ImageIcon ikon(int i)
    {
        java.awt.image.BufferedImage    kép = new java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics    g = kép.getGraphics();
        g.setColor(töltőszínek[i]);
        g.fillOval(2, 2, 12, 12);
        return new ImageIcon(kép);
    }

    private ImageIcon jelöltikon(int i)
    {
        java.awt.image.BufferedImage    kép = new java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics    g = kép.getGraphics();
        g.setColor(töltőszínek[i]);
        g.fillOval(2, 2, 12, 12);
        g.setColor(Color.black);
        g.drawRect(0, 0, 15, 15);
        return new ImageIcon(kép);
    }

    public static void main(String[] args)
    {
        new Tojások();
    }
}
