package hu.elte.progtech.zoo;

public class Animal {

    private String name;
    private Species species;

    public Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public String getVoice() {
        if (species == Species.LION) {
            return "meow";
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        String s = "There is a(n) " + species + " in the zoo, that is called " + name;
        if (species != Species.FISH) {
            s += " and introduces itself as " + getVoice();
        }
        return s;
    }

}
