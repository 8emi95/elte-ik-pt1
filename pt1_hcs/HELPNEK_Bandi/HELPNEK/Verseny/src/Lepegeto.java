/** Ez az osztály a lépegető lényfajtát valósítja meg, ha a kezdővíz nagyobb, 
    mint a fajra jellemző maximum víz, akkor a maximum vízzel indul el a versenyen a lény.
  * @author bandoo
  */
public class Lepegeto extends Leny {

    public Lepegeto(String name, int currentWater) {
        super(name, currentWater);
        waterusage.put("n", -2);
        waterusage.put("f", -1);
        waterusage.put("e", 3);
        movedunit.put("n", 1);
        movedunit.put("f", 2);
        movedunit.put("e", 1);
        max_water = 12;
        if (currentWater > max_water) {
            currentWater = max_water;
        }
    }
}