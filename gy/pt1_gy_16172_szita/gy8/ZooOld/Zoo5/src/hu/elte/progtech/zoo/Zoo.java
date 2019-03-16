package hu.elte.progtech.zoo;

import java.util.ArrayList;
import java.util.List;

import hu.elte.progtech.zoo.animal.Animal;
import hu.elte.progtech.zoo.animal.Fish;
import hu.elte.progtech.zoo.animal.Lion;

public class Zoo {

    public static void main(String args[]) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Lion("Simba"));
        animals.add(new Lion("Kimba"));
        animals.add(new Fish("Wanda"));

        for (Animal a : animals) {
            System.out.print("There is a(n) " + a.getSpecies() + " in the zoo, that is called " + a.getName());
            if (a instanceof SoundSource) {
                System.out.print(" and introduces itself as " + ((SoundSource) a).getVoice());
            }
            System.out.println();
            System.out.println(a);
        }
    }

}
