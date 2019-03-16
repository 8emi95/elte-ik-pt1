/*
 * Mintaprogramok/12. fejezet
 * OszintesegProba.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.event.*;

public class OszintesegProba extends JApplet implements
                                     ActionListener {
  JMenuBar mb = new JMenuBar();
  JMenu mProba = new JMenu("Pr�ba");
  JMenuItem miProba = new JMenuItem("�szintes�g",'�');
  JMenuItem miKilep = new JMenuItem("Kil�p",'K');

  public OszintesegProba() {
    //setBounds(200,50,500,300);
    setJMenuBar(mb);
    mb.add(mProba);
    mProba.setMnemonic('P');
    mProba.add(miProba);
    mProba.add(miKilep);
    miProba.addActionListener(this);
    miKilep.addActionListener(this);
  }

  // Pozit�v sz�m ism�telt bek�r�se, am�g nem �tnek be egyet.
  // Cancel eset�n a visszaadott �rt�k -1:
  double ev() {
    String evStr = "";
    double ev = 0;
    while (ev<=0) {
      try {
        evStr=JOptionPane.showInputDialog(this,            //1
          "H�ny �ves vagy?","�szintes�g pr�ba",
          JOptionPane.QUESTION_MESSAGE);
        if (evStr == null)
          return -1;
        else
          ev=Double.parseDouble(evStr);
      }
      catch (NumberFormatException ex) {
      }
      if (ev<=0)
        JOptionPane.showMessageDialog(this,                //2
          "Pozit�v sz�mot k�rek!","",JOptionPane.ERROR_MESSAGE);
    }
    return ev;
  }

  // A met�dus �szintes�get vizsg�l:
  void proba() {
    double ev = ev();
    if (ev == -1) {
      JOptionPane.showMessageDialog(this,"Na mi van, megfutamodt�l?");
      return;
    }
    if (ev < 40) {
      int option = JOptionPane.showConfirmDialog(this,"Biztos?",
        "",JOptionPane.YES_NO_CANCEL_OPTION);              //3
      if (option == JOptionPane.YES_OPTION)
        JOptionPane.showMessageDialog(this,"Nem hiszem!",  //4
          "",JOptionPane.WARNING_MESSAGE);
      else if (option == JOptionPane.NO_OPTION)
        JOptionPane.showMessageDialog(this,"Gondoltam!",   //5
          "Lebuk�s",JOptionPane.INFORMATION_MESSAGE);
      else
        JOptionPane.showMessageDialog(this,                //6
          "Te kis sunyi!");
    }
    else
      JOptionPane.showMessageDialog(this,                  //7
        "Ki�lltad a pr�b�t!","",
        JOptionPane.INFORMATION_MESSAGE);
  }

  // A message k�rd�sre Igen/Nem v�laszt v�r. true, ha igen:
  boolean tenyleg(String message) {
    Object[] opciok = {"Igen","Nem"};
    // Param: parent, message, title, optionType,
    //        messageType, icon, options, initialValue:
    int valasz = JOptionPane.showOptionDialog(this,        //8
      message,"",JOptionPane.DEFAULT_OPTION,
      JOptionPane.WARNING_MESSAGE,null,opciok,opciok[1]);
    return valasz==0;
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==miProba)
      proba();
    else if (ev.getSource()==miKilep) {
      if (tenyleg("Biztosan ki akar l�pni?"))
        System.exit(0);
    }
  }

}
