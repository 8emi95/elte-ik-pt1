import java.util.Vector;
import extra.Console;
/**
 * @author zentaidavid
 * @version 1.0
 * @created 24-szept.-2015 13:20:58
 */
public class TorpeProgram {

    private Vector<Ember> torpek;

    public TorpeProgram() {
        torpek = new Vector<Ember>();
    }

    public static void main(String[] args) {
        TorpeProgram tp = new TorpeProgram();
        tp.bevitel();
        tp.lista1();
        tp.lista2();
        tp.lista3();
        tp.lista4();
        tp.kereses();
    }

    public void bevitel() {
        String nev = Console.readLine("\nTorpe neve: ");
        while(!nev.equals("")) {
            Ember ember = new Ember(nev);
            if(torpek.contains(ember))
                System.out.println("Van mar ilyen torpe!");
            else {
                ember.setMagassag(Console.readInt("magassaga: "));
                torpek.add(ember);
            }
            nev = Console.readLine("Torpe neve: ");
        }
    }

    public void lista1() {
        System.out.println("\nBeepitett lista:");
        System.out.println(torpek);
    }

    public void lista2() {
        System.out.println("\nLista index szerint:");
        for (int i = 0; i < torpek.size(); i++) {
            System.out.println(torpek.get(i));
        }
    }

    public void lista3() {
        System.out.println("\nEgyeni lista:");
        for (int i = 0; i < torpek.size(); i++) {
            Ember ember = torpek.get(i);
            System.out.println("Nev "+ember.getNev() + " Magassag: "+ember.getMagassag());    
        }
    }

    public void lista4() {
        System.out.println("\nfor-each ciklussal: ");
        for(Ember ember : torpek) {
            System.out.println(ember);
        }
    }

    public void kereses() {
        System.out.println("\nKerese: ");
        Ember keresettEmber = new Ember(Console.readLine("Torpe neve: "));
        int poz = torpek.indexOf(keresettEmber);
        if (poz>= 0)
            System.out.println("Van, magassaga: "+torpek.get(poz).getMagassag());
        else
            System.out.println("Nincs ilyen");
    }
}//end TorpeProgram
