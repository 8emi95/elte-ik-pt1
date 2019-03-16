package hu.elte.progtech.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public static void main(String args[]) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Simba", Species.LION));
        animals.add(new Animal("Kimba", Species.LION));
        animals.add(new Animal("Wanda", Species.FISH));

        for (Animal a : animals) {
            System.out.print("There is a(n) " + a.getSpecies() + " in the zoo, that is called " + a.getName());
            try {
                System.out.println(" and introduces itself as " + a.getVoice());
            } catch (UnsupportedOperationException e) {
                System.out.println();
            }
            System.out.println(a);
        }
    }

}
