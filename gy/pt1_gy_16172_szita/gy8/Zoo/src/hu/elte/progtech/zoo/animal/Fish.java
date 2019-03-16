package hu.elte.progtech.zoo.animal;

import hu.elte.progtech.zoo.food.Omnivore;

public class Fish extends Omnivore {

    public Fish(String name) {
        super(name);
    }

    @Override
    public Species getSpecies() {
        return Species.FISH;
    }

}
