import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeretezesFrame extends JFrame {
    Container cp = getContentPane();
    ButtonGroup bg = new ButtonGroup();
    JRadioButton rbVesett = new JRadioButton("Vésett");
    JRadioButton rbKiemelt = new JRadioButton("Kiemelt");
    JRadioButton rbSullyesztett = new JRadioButton("Süllyesztett");
    JPanel pnValaszt = new JPanel();

    public KeretezesFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Keretezés próba");
        cp.setLayout(new FlowLayout());

        bg.add(rbVesett);
        pnValaszt.add(rbVesett);
        rbVesett.addActionListener(new ActionListener() { //belső osztály, ami új classfajlokat fog létrehozni
            public void actionPerformed(ActionEvent e) {
                pnValaszt.setBorder(BorderFactory.createEtchedBorder());
            }
        });

        bg.add(rbKiemelt);
        pnValaszt.add(rbKiemelt);
        rbKiemelt.addActionListener(new ActionListener() { //belső osztály, ami új classfajlokat fog létrehozni
            public void actionPerformed(ActionEvent e) {
                pnValaszt.setBorder(BorderFactory.createRaisedBevelBorder());
            }
        });

        bg.add(rbSullyesztett);
        pnValaszt.add(rbSullyesztett);
        rbSullyesztett.addActionListener(new ActionListener() { //belső osztály, ami új classfajlokat fog létrehozni
            public void actionPerformed(ActionEvent e) {
                pnValaszt.setBorder(BorderFactory.createLoweredBevelBorder());
            }
        });
        
        cp.add(pnValaszt);
        pack();
        setVisible(true);
    }
}

 public class RadioButtonTest {
    public static void main(String[] args) {
        new KeretezesFrame();
    }
    
}
