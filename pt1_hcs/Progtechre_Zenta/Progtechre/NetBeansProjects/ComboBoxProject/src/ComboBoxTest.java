import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SzinekFrame extends JFrame implements ActionListener{// actionlistenerhez mingódig tartozik actionperformed metódus is
    Color[] colors = {Color.WHITE,  Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.RED};
    String[] colorStrings = {"fehér","fekete","kék","türkiz","szürke","zöld","piros"};
    Container cp = getContentPane();
    JComboBox cbSzinek;
    
    public SzinekFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Szinek");
        setBounds(300, 100, 200, 200);
        cp.setLayout(new FlowLayout());
        cp.setBackground(colors[0]);
        cp.add(cbSzinek = new JComboBox(colorStrings)); //alapértelmezetten középre helyezi
        cbSzinek.addActionListener(this); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        cp.setBackground(colors[cbSzinek.getSelectedIndex()]);
    }
}

public class ComboBoxTest {

    public static void main(String[] args) {
        new SzinekFrame();
    }
    
}
