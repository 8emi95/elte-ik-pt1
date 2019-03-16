/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lego_javitott;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author Dobreff András
 */
public class LEGO_javitott {
    public static void main(String[] args) {
        Vector<Elem> elemek = new Vector<>();
        Tipus kek_kocka = new Tipus(new String("2x2 kocka"), new Color(0, 0, 255), 2);
        for(int i = 0; i<15000000; ++i){
            elemek.add(new Elem(kek_kocka));
        }
        System.out.println("DONE");
    }
}
