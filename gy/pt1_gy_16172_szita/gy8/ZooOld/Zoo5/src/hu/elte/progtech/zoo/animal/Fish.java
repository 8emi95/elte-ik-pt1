package hu.elte.progtech.zoo.animal;

public class Fish extends Animal {

    public Fish(String name) {
        super(name);
    }

    @Override
    public Species getSpecies() {
        return Species.FISH;
    }

}
