package hu.elte.progtech.legion.soldier;

import static hu.elte.progtech.legion.soldier.model.Hand.LEFT;
import static hu.elte.progtech.legion.soldier.model.Hand.RIGHT;

import java.util.Random;

import hu.elte.progtech.legion.soldier.model.Hand;

public abstract class Soldier {

    protected static final Random random = new Random(System.currentTimeMillis());

    private boolean hasPossessed = false;

    public boolean guess(Soldier possessor) {
        return getChoice(possessor).equals(possessor.shuffle());
    }

    protected Hand getChoice(Soldier possessor) {
        return getFiftyFiftyHand();
    }

    protected Hand shuffle() {
        return getFiftyFiftyHand();
    }

    protected Hand getFiftyFiftyHand() {
        return random.nextBoolean() ? LEFT : RIGHT;
    }

    public boolean hasPossessed() {
        return hasPossessed;
    }

    public void setPossessed() {
        hasPossessed = true;
    }

}
