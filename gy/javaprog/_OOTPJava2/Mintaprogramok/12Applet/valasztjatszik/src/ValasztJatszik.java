/*
 * Mintaprogramok/12. fejezet
 * Projekt: ValasztJatszik
 * ValasztJatszik.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;

public class ValasztJatszik extends JFrame
                            implements ActionListener {
  private Container cp;
  private JMenuItem miValaszt, miKikapcsol, miVege;
  private AudioClip ac;                                    //2
  private JFileChooser fc = new JFileChooser("c:/javaprog/sounds");

  public ValasztJatszik() {
    setBounds(100,100,400,200);
    setTitle("Hangfájlok választása és lejátszása");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp = getContentPane();

    JMenuBar mb;
    JMenu mFile, mZene;
    setJMenuBar(mb=new JMenuBar());
    mb.add(mFile=new JMenu("File"));
    mFile.add(mZene = new JMenu("Zene"));
    mZene.add(miValaszt=new JMenuItem("Választ"));
    mZene.add(miKikapcsol=new JMenuItem("Kikapcsol"));
    mFile.add(miVege = new JMenuItem("Vége"));

    miVege.addActionListener(this);
    miValaszt.addActionListener(this);
    miKikapcsol.addActionListener(this);

    miKikapcsol.setEnabled(false);
    fc.setFileFilter(new AudioFilter());                   //3
    show();
  }

  void zeneValaszt() {
    if (fc.showOpenDialog(this)!=fc.APPROVE_OPTION)
      return;
    try {
      URL url = new URL("file:///"+fc.getSelectedFile());  //4
      ac = Applet.newAudioClip(url);
      miKikapcsol.setEnabled(true);
      ac.play();
    }
    catch(Exception ex) {
      System.out.println(ex);
    }
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==miValaszt) {
      zeneValaszt();
    }
    else if (ev.getSource()==miKikapcsol) {
      ac.stop();                                           //5
      miKikapcsol.setEnabled(false);
    }
    else if (ev.getSource()==miVege)
      System.exit(0);
  }

  public static void main(String[] args) {
    new ValasztJatszik();
  }
}
