package java_bead_leny;

import java.util.*;

public abstract class Leny {

    protected String name;
    protected int max_water;
    protected boolean isalive = true;
    protected int watertouse;
    protected int roadsofar;

    protected final HashMap<String, Integer> waterusage = new HashMap<>();
    protected final HashMap<String, Integer> movedunit = new HashMap<>();

    public Leny(String name, int watertouse) {
        this.name = name;
        this.watertouse = watertouse;
    }
    
    public void sunny() {
        if (isalive) {
            watertouse += waterusage.get("n");
            if (watertouse <= 0) {
                watertouse = 0;
                isalive = false;
            } else if (watertouse > max_water) {
                watertouse = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("n");
            }
        }
    }
    
    public void rainy() {
        if (isalive) {
            watertouse += waterusage.get("e");
            if (watertouse <= 0) {
                watertouse = 0;
                isalive = false;
            } else if (watertouse > max_water) {
                watertouse = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("e");
            }
        }
    }
    
    public void cloudy() {
        if (isalive) {
            watertouse += waterusage.get("f");
            if (watertouse <= 0) {
                watertouse = 0;
                isalive = false;
            } else if (watertouse > max_water) {
                watertouse = max_water;
            }
            if (isalive) {
                roadsofar += movedunit.get("f");
            }
        }
    }
    
    public boolean isAlive() {
        return isalive;
    }
   
    public String getName() {
        return name;
    }
    
    public int roadSoFar() {
        return roadsofar;
    }
}
