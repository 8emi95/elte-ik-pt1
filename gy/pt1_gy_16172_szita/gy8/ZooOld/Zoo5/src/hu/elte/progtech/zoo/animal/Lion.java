package hu.elte.progtech.zoo.animal;

import hu.elte.progtech.zoo.SoundSource;

public class Lion extends Animal implements SoundSource {

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
