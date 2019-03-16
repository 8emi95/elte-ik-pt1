/** Ez az osztály a szivacs lényfajtát valósítja meg, ha a kezdővíz nagyobb, 
    mint a fajra jellemző maximum, akkor a maximum vízzel indul el a versenyen a lény.
  * @author bandoo
  */
public class Szivacs extends Leny {

    public Szivacs(String name, int currentWater) {
        super(name, currentWater);
        waterusage.put("n", -4);
        waterusage.put("f", -1);
        waterusage.put("e", 6);
        movedunit.put("n", 0);
        movedunit.put("f", 1);
        movedunit.put("e", 3);
        max_water = 20;
        if (currentWater > max_water) {
            currentWater = max_water;
        }
    }
}