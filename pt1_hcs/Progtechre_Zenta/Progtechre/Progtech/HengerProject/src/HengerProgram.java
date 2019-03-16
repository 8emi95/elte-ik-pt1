
/**
 * @author zentaidavid
 * @version 1.0
 * @created 01-okt.-2015 12:57:00
 */
import extra.Format;
import java.util.Vector;

public class HengerProgram {

    private Vector<Henger> hengerek = new Vector<Henger>();

    public HengerProgram() {
        hengerek.add(new Henger(1, 4));
        hengerek.add(new Rud(0.5, 4, 2));
        hengerek.add(new Rud(0.5, 4));
        hengerek.add(new Cso(5, 5, 0.5));
        hengerek.add(new Cso(5, 5, 0.5, 2));
    }

    public double atlagTerfogat() {
        double osszTerfogat = 0;
        for (Henger h : hengerek) {             /*foreach*/

            osszTerfogat += h.terfogat();
        }
        int meret = hengerek.size();
        return meret == 0 ? 0 : osszTerfogat / meret;
    }

    public void lista(Vector<Henger> vektor) {
        for (Henger h : vektor) {
            System.out.println(h);
        }
    }

    public void run() {
        System.out.println("Hengerek száma: "+ hengerek.size());
        lista(hengerek);
        System.out.println("\nÁtlagtérfogat: " + Format.right(atlagTerfogat(), 0, 2));
        double suly=0;
        System.out.println("\nCsövek listája");
        for(Henger h: hengerek) {
            if(h instanceof Cso) {
                System.out.println(h);
                suly += ((Cso)h).suly();
            }
        }
        System.out.println("\nCsövek súlya összesen: " + Format.right(suly,0,2));
        System.out.println("\nSzületett hengerek száma: " + Henger.getSzuletesSzamlalo());
    }

    public static void main(String[] args) {
        new HengerProgram().run();
    }
}//end HengerProgram
