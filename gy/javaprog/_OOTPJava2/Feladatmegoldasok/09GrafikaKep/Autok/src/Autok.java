/*
 * Feladatmegold�sok/9. fejezet
 * Projekt: Autok
 * Autok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * (B) K�sz�tsen egy sz�nes kisaut�t! A kisaut� sz�n�t l�trehoz�skor adjuk meg.
 *    a) Tegyen egy piros kisaut�t a keret (100,100) pontj�ra!
 *    b) Tegyen egy k�k kisaut�t a keret k�zep�re!
 *    c) Tegyen sok kisaut�t a keretbe!
 */

import javax.swing.*;
import java.awt.*;

public class Autok extends JFrame {
  Container cp = getContentPane();

  public Autok() {
    setTitle("Aut�k");
    setBounds(50,50,600,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Nem kell elerendez�s-menedzser, mi adjuk meg az aut�k koordin�t�it:
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