import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTestFrame extends JFrame implements ActionListener{    // actionlistenerhez mingódig tartozik actionperformed metódus is
    JMenuBar mb = new JMenuBar();
    JMenu mSzinezes = new JMenu("Színezes");
    JMenuItem miSzovegSzin = new JMenuItem("Szövegszín", 'Z');
    JMenuItem miHatterSzin = new JMenuItem("Háttérszín", 'H');
    JMenuItem miSzoveg = new JMenuItem("Szöveg", 'S');
    JMenuItem miKilep = new JMenuItem("Kilép",'K');
    JMenu mSugo = new JMenu("Sugó");
    JMenuItem miNevjegy = new JMenuItem("Névjegy");
    JLabel lbSzoveg = new JLabel("JAVA");
    
    public MenuTestFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 50, 400, 300);
        setTitle("Menü teszt");
        getContentPane().add(lbSzoveg);
        lbSzoveg.setFont(new Font("Dialog", Font.BOLD, 30));
        lbSzoveg.setHorizontalAlignment(JLabel.CENTER);
        lbSzoveg.setOpaque(true);
        
        setJMenuBar(mb);
        mb.add(mSzinezes);
        mSzinezes.setMnemonic('S');
        mSzinezes.add(miSzovegSzin);
        mSzinezes.addSeparator(); //elválasztóvonal a menüben
        mSzinezes.add(miHatterSzin);
        mSzinezes.addSeparator();
        mSzinezes.add(miSzoveg);
        mSzinezes.addSeparator();
        mSzinezes.add(miKilep);
        mb.add(mSugo);
        mSugo.add(miNevjegy);
        miSzovegSzin.addActionListener(this);
        miHatterSzin.addActionListener(this);
        miSzoveg.addActionListener(this);
        miKilep.addActionListener(this);
        miNevjegy.addActionListener(this);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == miSzovegSzin) {
            Color fg = JColorChooser.showDialog(this, "Szövegszín", lbSzoveg.getForeground());
            if(fg!=null)
                lbSzoveg.setForeground(fg);
        }
        else if (e.getSource() == miHatterSzin){
            Color bg = JColorChooser.showDialog(this,"Háttérszín", lbSzoveg.getBackground());
            if(bg != null)
                lbSzoveg.setBackground(bg);
        }
        else if (e.getSource() == miSzoveg){
            String szoveg = JOptionPane.showInputDialog(this, "Szöveg");
            if(szoveg != null)
                lbSzoveg.setText(szoveg);
        }
        else if (e.getSource() == miKilep){
            Object[] opciok = {"Igen","Nem"};
            int valasz = JOptionPane.showOptionDialog(this, "Biztosan kilép?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciok, opciok[1]);
            //this, szöveg, címsorszöveg, opcioválasztás sok opcioval, megjelenik a kérdőjel ikon, meglehet adni saját ikont is, opciok tömb a lehetöségek, alap kijelölés az igen
            if(valasz == 0)
                System.exit(0);
        }
        else if (e.getSource() == miNevjegy){
            JOptionPane.showMessageDialog(this, "Névjegy", "",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        new MenuTestFrame();
    }
    
}
