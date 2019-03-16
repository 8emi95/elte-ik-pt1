package java_bead_leny;

import java.util.HashMap;

public class Szivacs extends Leny {

    public Szivacs(String name, int watertouse) {
        super(name, watertouse);
        waterusage.put("n", -4);
        waterusage.put("f", -1);
        waterusage.put("e", 6);
        movedunit.put("n", 0);
        movedunit.put("f", 1);
        movedunit.put("e", 3);
        max_water = 20;
        if (watertouse > max_water) {
            watertouse = max_water;
        }
    }
}
