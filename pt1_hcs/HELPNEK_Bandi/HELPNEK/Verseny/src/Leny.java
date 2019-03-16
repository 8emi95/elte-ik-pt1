/**
 * A fő absztrakt lény osztály, amiből származtatjuk az összes lényfajtát.
 * @author bandoo
 */
import java.util.*;

public abstract class Leny {
    protected String name;
    protected int max_water;
    protected boolean isalive = true;
    protected int currentWater;
    protected int roadsofar;

    protected final HashMap<String, Integer> waterusage = new HashMap<>();
    protected final HashMap<String, Integer> movedunit = new HashMap<>();

    public Leny(String name, int currentWater) {
        this.name = name;
        this.currentWater = currentWater;
    }
    
    /** Ha napos idő van, akkor hívódik meg ez a metódus és, ha életben van a lény,
     *  akkor levonja a vizet. Ha még mindig él a lény, akkor mozog a rá jellemző mennyiséget. */
    
    public void sunny() {
        if (isalive) {
            currentWater += waterusage.get("n");
            if (currentWater <= 0) {
                currentWater = 0;
                isalive = false;
            } else if (currentWater > max_water) {
                currentWater = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("n");
            }
        }
    }
    
    /** Ha esős idő van, akkor hívódik meg ez a metódus és, ha életben van a lény,
     *  akkor levonja a vizet. Ha még mindig él a lény, akkor mozog a rá jellemző mennyiséget. */
    
    public void rainy() {
        if (isalive) {
            currentWater += waterusage.get("e");
            if (currentWater <= 0) {
                currentWater = 0;
                isalive = false;
            } else if (currentWater > max_water) {
                currentWater = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("e");
            }
        }
    }
    
    /** Ha felhős idő van, akkor hívódik meg ez a metódus és, ha életben van a lény,
     *  akkor levonja a vizet. Ha még mindig él a lény, akkor mozog a rá jellemző mennyiséget. */
    
    public void cloudy() {
        if (isalive) {
            currentWater += waterusage.get("f");
            if (currentWater <= 0) {
                currentWater = 0;
                isalive = false;
            } else if (currentWater> max_water) {
                currentWater = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("f");
            }
        }
    }
    /** Visszaadja, hogy él-e a lény. 
     *@return isalive
     */
    public boolean isAlive() {
        return isalive;
    }
    /** Visszaadja a lény nevét. 
     * @return name
     */
    public String getName() {
        return name;
    }
    /** Visszaadja, hogy mennyi utat tett meg eddig a lény. 
     * @return roadsofar
     */
    public int roadSoFar() {
        return roadsofar;
    }
}