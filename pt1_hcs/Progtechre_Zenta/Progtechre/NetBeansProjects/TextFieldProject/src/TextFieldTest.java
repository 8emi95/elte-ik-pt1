import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NevPanel extends JPanel implements ActionListener {
    private JTextField tfVezetekNev, tfKeresztNev, tfTeljesNev;
    private JLabel lbMonogram;
   
    public NevPanel(){
        setLayout(new GridLayout(3,1));
        JPanel pn = new JPanel();
        pn.add(new JLabel("Vezetéknév:"));
        pn.add(tfVezetekNev = new JTextField(10));
        pn.add(new JLabel("Keresztnév:"));
        pn.add(tfKeresztNev = new JTextField(10));
        add(pn);
       
        pn = new JPanel();
        pn.add(new JLabel("Teljes név:"));
        pn.add(tfTeljesNev = new JTextField(20));
        tfTeljesNev.setEditable(false);
        add(pn);
       
        pn = new JPanel();
        pn.add(new JLabel("Monogram:"));
        pn.add(lbMonogram = new JLabel(""));
        add(pn);
       
        tfVezetekNev.addActionListener(this);
        tfKeresztNev.addActionListener(this);
    }
   
    public void actionPerformed(ActionEvent ev){
        String vez = tfVezetekNev.getText();
        String ker = tfKeresztNev.getText();
        tfTeljesNev.setText(vez + " " + ker);
        try{
            lbMonogram.setText(vez.charAt(0) + ". " + ker.charAt(0)+ ".");
        }catch(StringIndexOutOfBoundsException ex){
            lbMonogram.setText("");
        }
    }
}
 
public class TextFieldTest extends JFrame {
    public TextFieldTest(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Név összerakása");
        setLocation(300,200);
        getContentPane().add(new NevPanel());
        pack();
        setVisible(true);
    }
   
    public static void main(String[] args) {
        new TextFieldTest();
    }
}