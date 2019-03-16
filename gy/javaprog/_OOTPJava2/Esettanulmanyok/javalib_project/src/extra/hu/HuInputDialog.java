/*
 * Csomag: extra.hu
 * InputDialog.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Magyar dial�gus ablak. show met�dusa bek�r egy Stringet.
 */

package extra.hu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HuInputDialog extends JDialog implements ActionListener {
  private JPanel cp = (JPanel)getContentPane();
  private int option;
  private JLabel lbMessage = new JLabel(" ");
  private JTextField tfInput = new JTextField(15);
  private JButton btOk, btCancel;

  public HuInputDialog(JFrame parent, String title) {
    super(parent,title,true);
    cp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

    JLabel lbIcon = new JLabel(new ImageIcon(getClass().getResource("question.gif")));
    lbIcon.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    cp.add(lbIcon,"West");

    JPanel pnBody = new JPanel();
    cp.add(pnBody,"Center");
    pnBody.setLayout(new GridLayout(0,1));
    pnBody.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    pnBody.add(lbMessage);
    pnBody.add(tfInput);
    tfInput.addActionListener(this);
    tfInput.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== e.VK_ESCAPE) {
          option = JOptionPane.NO_OPTION;
          dispose();
        }
        else if (e.getKeyCode()== e.VK_ENTER) {
          option = JOptionPane.YES_OPTION;
          dispose();
        }
      }
    });

    JPanel pnControl = new JPanel();
    cp.add(pnControl,"South");
    btOk = new JButton("Rendben");
    btOk.setMnemonic('R');
    pnControl.add(btOk);
    btOk.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        option = JOptionPane.YES_OPTION;
        dispose();
      }
    });

    btCancel = new JButton("M�gse");
    btCancel.setMnemonic('M');
    pnControl.add(btCancel);
    btCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        option = JOptionPane.CANCEL_OPTION;
        dispose();
      }
    });
  }

  public String show(Object message, Object initValue) {
    lbMessage.setText(message.toString());
    tfInput.setText(initValue.toString());
    pack();
    setLocationRelativeTo(getParent());
    tfInput.requestFocus();
    tfInput.selectAll();
    show();
    if (option == JOptionPane.YES_OPTION)
      return tfInput.getText();
    else
      return null;
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource() == btOk)
      option = JOptionPane.YES_OPTION;
    else
      option = JOptionPane.NO_OPTION;
    dispose();
  }

} // HuInputDialog
