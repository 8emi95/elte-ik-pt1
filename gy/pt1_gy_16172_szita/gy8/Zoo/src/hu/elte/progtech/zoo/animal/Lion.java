package hu.elte.progtech.zoo.animal;

import hu.elte.progtech.zoo.SoundSource;
import hu.elte.progtech.zoo.food.Carnivore;

public class Lion extends Carnivore implements SoundSource {

    public Lion(String name) {
        super(name);
    }

    @Override
    public String getVoice() {
        return "meow";
    }

    @Override
    public Species getSpecies() {
        return Species.LION;
    }

    @Override
    public String toString() {
        return super.toString() + " and introduces itself as " + getVoice();
    }
}
