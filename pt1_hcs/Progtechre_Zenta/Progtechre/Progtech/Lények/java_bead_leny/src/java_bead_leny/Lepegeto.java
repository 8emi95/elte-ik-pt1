package java_bead_leny;

import java.util.HashMap;

public class Lepegeto extends Leny {

    public Lepegeto(String name, int watertouse) {
        super(name, watertouse);
        waterusage.put("n", -2);
        waterusage.put("f", -1);
        waterusage.put("e", 3);
        movedunit.put("n", 1);
        movedunit.put("f", 2);
        movedunit.put("e", 1);
        max_water = 12;
        if (watertouse > max_water) {
            watertouse = max_water;
        }
    }
}
