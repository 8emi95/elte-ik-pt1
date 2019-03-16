package hu.elte.progtech.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public static void main(String args[]) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Simba", Species.LION, "meow"));
        animals.add(new Animal("Kimba", Species.LION, "meow"));
        animals.add(new Animal("Wanda", Species.FISH, "..."));

        for (int i = 0; i < animals.size(); ++i) {
            System.out.print("There is a(n) " + animals.get(i).getSpecies() + " in the zoo, that is called " + animals.get(i).getName());
            if (!"...".equals(animals.get(i).getVoice())) {
                System.out.print(" and introduces itself as " + animals.get(i).getVoice());
            }
            System.out.println();
            System.out.println(animals.get(i));
        }

    }

}
