package lego_naiv;

import java.awt.Color;
import java.util.Vector;

/**
 * @author Dobreff András
 */
public class LEGO_naiv {

    public static void main(String[] args) {
        Vector<Elem> elemek = new Vector<>();
        for(int i = 0; i<15000000; ++i){
            elemek.add(new Elem(new String("2x2 kocka"), new Color(255, 0, 0), 2));
        }
        System.out.println("DONE");
    }
}
