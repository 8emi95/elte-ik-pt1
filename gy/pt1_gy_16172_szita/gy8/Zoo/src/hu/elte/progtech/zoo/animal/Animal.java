package hu.elte.progtech.zoo.animal;

import hu.elte.progtech.zoo.food.Food;

public abstract class Animal implements Food {

    private String name;
    protected boolean isFed = false;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void feed() {
        isFed = true;
    }

    public abstract Species getSpecies();

    @Override
    public String toString() {
        return "There is a(n) " + getSpecies() + " in the zoo, that is called " + name;
    }

}
