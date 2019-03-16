/*
 * Mintaprogramok/Feladatok
 * Projekt: MosaicDesign
 * MosaicDesign.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

package mosaicdesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import extra.util.*;
import java.io.*;

public class MosaicDesign extends JFrame implements ActionListener {
  Container cp = getContentPane();
  JFileChooser fc = new JFileChooser();
  JPanel pnControl = new JPanel();
  JButton btClear = new JButton("Töröl");
  JButton btOpen = new JButton("Betöltés");
  JButton btSave = new JButton("Mentés");
  JButton btColor = new JButton("Csempeszín");
  JButton btExit = new JButton("Kilépés");
  MosaicSurface mosaicSurface = new MosaicSurface(11, 11);
  Color color = new Color(240, 220, 60);

  public MosaicDesign() {
    setTitle("Csempetervezõ");
    setSize(500, 400);
    fc.setCurrentDirectory(new File("."));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pnControl.setBorder(BorderFactory.createRaisedBevelBorder());
    btClear.addActionListener(this);
    btOpen.addActionListener(this);
    btSave.addActionListener(this);
    btColor.addActionListener(this);
    btExit.addActionListener(this);
    cp.add(pnControl, BorderLayout.NORTH);
    pnControl.add(btClear);
    pnControl.add(btOpen);
    pnControl.add(btSave);
    pnControl.add(btColor);
    pnControl.add(btExit);
    cp.add(mosaicSurface);
    show();
    setLocationRelativeTo(null);
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == btClear) {
      mosaicSurface.clear();
    }
    else if (ae.getSource() == btOpen) {
      if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
        return;
      File f = fc.getSelectedFile();
      mosaicSurface.readFromFile(f);
    }
    if (ae.getSource() == btSave) {
      if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION)
        return;
      File f = fc.getSelectedFile();
      mosaicSurface.writeToFile(f);
    }
    else if (ae.getSource() == btColor) {
      color = JColorChooser.showDialog(this, "A következõ csempe színe", color);
      btColor.setBackground(color);
      mosaicSurface.setPaintColor(color);
    }
    else if (ae.getSource() == btExit) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    MosaicDesign mosaicDesign = new MosaicDesign();
  }
}