package lego_static;

import java.util.LinkedList;

/**
 *
 * @author Dobreff András
 */
public class LEGO_static {
    public static void main(String[] args) {
        LinkedList<Elem> list = new LinkedList<>();
        for(int i = 0; i<10000000; ++i){
            list.add(new Elem());
        }
        System.out.println("DONE");
    }
}
