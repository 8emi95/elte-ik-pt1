/*
 * Projekt: javalib
 *
 * Csomag: extra.hu
 * HuOptionPane.java
 *
 * JOptionPane magyar�t�sa.
 * Csak a legfontosabb met�dusok vannak defini�lva.
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package extra.hu;

import javax.swing.*;
import java.awt.*;

public class HuOptionPane extends JOptionPane {

  // Visszaadja az option_type-nak megfelel� options t�mb�t magyar feliratokkal:
  protected static Object[] options(int option_type) {
    Object[] options_YES_NO = {"Igen","Nem"};
    Object[] options_YES_NO_CANCEL = {"Igen","Nem","M�gse"};
    Object[] options_OK_CANCEL = {"Rendben","M�gse"};

    Object[] options = {""};
    System.out.println(option_type);
    if (option_type == YES_NO_OPTION)             //0
      options = options_YES_NO;
    else if (option_type == YES_NO_CANCEL_OPTION) //1
      options = options_YES_NO_CANCEL;
    else                                          //2
      options = options_OK_CANCEL;
    return options;
  }

  /* MessageDialog. Lehets�ges param�terei:
     Component parent, Object message, String title, int message_type, Icon icon
     Alap�rtelmez�s: Gomb:Rendben, title:"�zenet".
   */
  public static void showMessageDialog(Component parent,
        Object message, String title, int message_type, Icon icon) {
    Object[] options = {"Rendben"};
    JOptionPane.showOptionDialog(parent,message,title,JOptionPane.YES_OPTION,
      message_type,icon,options,options[0]);
  }

  public static void showMessageDialog(Component parent,
        Object message, String title, int message_type) {
    Object[] options = {"Rendben"};
    JOptionPane.showOptionDialog(parent,message,title,JOptionPane.YES_OPTION,
      message_type,null,options,options[0]);
  }

  public static void showMessageDialog(Component parent, Object message) {
    Object[] options = {"Rendben"};
    JOptionPane.showOptionDialog(parent,message,"�zenet",JOptionPane.YES_OPTION,
      JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
  }

  /* ConfirmDialog. Lehets�ges param�terei:
     Component parent, Object message, String title, int option_type, int message_type, Icon icon
     Alap�rtelmez�s: Gomb:Igen/Nem/M�gse, title:"K�rd�s".
   */

  public static int showConfirmDialog(Component parent,
        Object message, String title, int option_type, int message_type, Icon icon) {
    Object[] options = options(option_type);
    /*
    K�r, hogy nem megy �gy:
    JButton[] options = new JButton[3];
    options[0] = new JButton("Igen");
    options[0].setMnemonic('I');
    options[1] = new JButton("Nem");
    options[1].setMnemonic('N');
    options[2] = new JButton("M�gse");
    options[2].setMnemonic('M');
    */
    return JOptionPane.showOptionDialog(parent,message,title,option_type,
      message_type,icon,options,options[0]);
  }

  public static int showConfirmDialog(Component parent,
        Object message, String title, int option_type, int message_type) {
    Object[] options = options(option_type);
    return JOptionPane.showOptionDialog(parent,message,title,option_type,
      message_type,null,options,options[0]);
  }

  public static int showConfirmDialog(Component parent,
        Object message, String title, int option_type) {
    Object[] options = options(option_type);
    return JOptionPane.showOptionDialog(parent,message,title,option_type,
      JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
  }

  public static int showConfirmDialog(Component parent,Object message) {
    Object[] options = options(YES_NO_CANCEL_OPTION);
    return JOptionPane.showOptionDialog(parent,message,"V�laszt�s",
      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
      null,options,options[0]);
  }

  /* InputDialog. Lehets�ges param�terei:
     JFrame parent, Object message, String title, int message_type, Icon icon,
     Object intitValue
     Alap�rtelmez�s: Gomb:Rendben/M�gse, title:"Bevitel".
   */
  public static String showInputDialog(JFrame parent,Object message,
      String title,Object initValue) {
    return new HuInputDialog(parent,title).show(message,initValue);
  }

  public static String showInputDialog(JFrame parent,Object message,
      Object initValue) {
    return new HuInputDialog(parent,"Bevitel").show(message,initValue);
  }

  public static String showInputDialog(Object message,Object initValue) {
    return new HuInputDialog(null,"Bevitel").show(message,initValue);
  }

  public static String showInputDialog(JFrame parent,Object message) {
    return new HuInputDialog(parent,"Bevitel").show(message,"");
  }

  public static String showInputDialog(JFrame parent) {
    return new HuInputDialog(parent,"Bevitel").show("","");
  }
}
