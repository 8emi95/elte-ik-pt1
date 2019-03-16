import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

public class MVC_Demo extends JFrame {
  Container cp = getContentPane();
  Document doc = new PlainDocument();       //1
  JTextArea taText1 = new JTextArea(doc);   //2
  JTextArea taText2 = new JTextArea(doc);

  public MVC_Demo() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));
    cp.add(new JScrollPane(taText1));
    cp.add(new JScrollPane(taText2));
    show();
  }

  public static void main(String[] args) {
    new MVC_Demo();
  }
}
