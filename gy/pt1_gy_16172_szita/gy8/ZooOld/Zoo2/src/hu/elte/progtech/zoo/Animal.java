package hu.elte.progtech.zoo;

public class Animal {

    private String name;
    private String species;
    private String voice;

    public Animal(String name, String species, String voice) {
        this.name = name;
        this.species = species;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getVoice() {
        return voice;
    }

    @Override
    public String toString() {
        String s = "There is a(n) " + species + " in the zoo, that is called " + name;
        if (voice != "...") {
            s += " and introduces itself as " + voice;
        }
        return s;
    }

}
