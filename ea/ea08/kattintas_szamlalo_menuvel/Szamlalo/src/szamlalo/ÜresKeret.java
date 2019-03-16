package szamlalo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.*;

public class ÜresKeret extends JFrame{
    private SzámlálóGomb    számlálógomb;
    private SzámlálóCímke   számlálóCímke;
    private int             számláló = 0;
    private JMenuItem       menuNullázás;
    
    public ÜresKeret()
    {
        addWindowListener(new Kilépés());
        setTitle("Számláló");
        setSize(400, 150);
       
        számlálóCímke = new SzámlálóCímke();
        számlálógomb = new SzámlálóGomb(this);
        JComponent kilépésgomb = new KilépésGomb();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(számlálóCímke)
                    .addComponent(számlálógomb))
            .addComponent(kilépésgomb)
        );
        
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addComponent(számlálóCímke)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(számlálógomb)
                .addComponent(kilépésgomb))
        );
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu    menuTevékenység = new JMenu("Tevékenységek");
        menuTevékenység.setMnemonic('T');
        menuNullázás = new JMenuItem();
        menuNullázás.setAction(new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                számlálóCímke.setKattintasokSzama(számláló = 0);
                menuNullázás.setEnabled(false);
            }
        });
        menuNullázás.setText("Nullázás");
        menuNullázás.setMnemonic('N');
        menuNullázás.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        menuNullázás.setEnabled(false);
        

        JMenuItem menuKilépés = new JMenuItem(new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kilépés().windowClosing(null); // System.exit(0);
            }
        });
        menuKilépés.setText("Kilépés");
        menuKilépés.setMnemonic('K');
        menuKilépés.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.ALT_MASK));

        menuTevékenység.add(menuNullázás);
        menuTevékenység.addSeparator();
        menuTevékenység.add(menuKilépés);
        menuBar.add(menuTevékenység);
        setJMenuBar(menuBar);

        java.net.URL url = ÜresKeret.class.getResource("gomb.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setVisible(true);
        
        addMouseListener(egérAdapter);
        addMouseMotionListener(egérAdapter);
        addMouseWheelListener(egérAdapter);
    }
    
    private final MouseAdapter egérAdapter = new MouseAdapter() {

        @Override
        public void mouseMoved(MouseEvent e) {
            setTitle("Számláló - " + e.getX() + "," + e.getY());
            super.mouseMoved(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            setTitle("Számláló - " + e.getPreciseWheelRotation());
            super.mouseWheelMoved(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle("Számláló - MouseOut");
            super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setTitle("Számláló - MouseIn");
            super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
        }
            
    };
    
    public void SzámlálóNövelés()
    {
        menuNullázás.setEnabled(true);
        számlálóCímke.setKattintasokSzama(++számláló);
    }
}
