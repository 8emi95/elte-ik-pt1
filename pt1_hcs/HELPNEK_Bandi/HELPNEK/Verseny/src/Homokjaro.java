/** Ez az osztály a homokjáró lényfajtát valósítja meg, ha a kezdővíz nagyobb, 
    mint a fajra jellemző maximum víz, akkor a maximum vízzel indul el a versenyen a lény.
  * @author bandoo
  */
public class Homokjaro extends Leny {

    public Homokjaro(String name, int currentWater) {
        super(name, currentWater);
        waterusage.put("n", -1);
        waterusage.put("f", 0);
        waterusage.put("e", 3);
        movedunit.put("n", 3);
        movedunit.put("f", 1);
        movedunit.put("e", 0);
        max_water = 8;
        if (currentWater > max_water) {
            currentWater = max_water;
        }
    }
}