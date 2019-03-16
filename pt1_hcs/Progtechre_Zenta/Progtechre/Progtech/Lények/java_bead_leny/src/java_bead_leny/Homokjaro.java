package java_bead_leny;

import java.util.HashMap;

public class Homokjaro extends Leny {

    public Homokjaro(String name, int watertouse) {
        super(name, watertouse);
        waterusage.put("n", -1);
        waterusage.put("f", 0);
        waterusage.put("e", 3);
        movedunit.put("n", 3);
        movedunit.put("f", 1);
        movedunit.put("e", 0);
        max_water = 8;
        if (watertouse > max_water) {
            watertouse = max_water;
        }
    }
}
