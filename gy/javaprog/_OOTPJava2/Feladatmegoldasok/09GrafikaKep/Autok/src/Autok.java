/*
 * Feladatmegoldások/9. fejezet
 * Projekt: Autok
 * Autok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * (B) Készítsen egy színes kisautót! A kisautó színét létrehozáskor adjuk meg.
 *    a) Tegyen egy piros kisautót a keret (100,100) pontjára!
 *    b) Tegyen egy kék kisautót a keret közepére!
 *    c) Tegyen sok kisautót a keretbe!
 */

import javax.swing.*;
import java.awt.*;

public class Autok extends JFrame {
  Container cp = getContentPane();

  public Autok() {
    setTitle("Autók");
    setBounds(50,50,600,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Nem kell elerendezés-menedzser, mi adjuk meg az autók koordinátáit:
    cp.setLayout(null);

    Auto pirosAuto = new Auto(Color.red);
    pirosAuto.setLocation(100,100);
    cp.add(pirosAuto);

    Auto kekAuto = new Auto(Color.blue);
    kekAuto.setLocation(getWidth()/2,getHeight()/2);
    cp.add(kekAuto);

    cp.add(new Auto(Color.yellow));
    show();
  }

  public static void main(String[] args) {
    new Autok();
  }
}