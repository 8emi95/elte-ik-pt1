package hu.elte.progtech.zoo.animal;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Species getSpecies();

    @Override
    public String toString() {
        return "There is a(n) " + getSpecies() + " in the zoo, that is called " + name;
    }

}
