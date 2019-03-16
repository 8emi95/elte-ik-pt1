package hu.elte.progtech.legion.soldier;

import static hu.elte.progtech.legion.soldier.model.Hand.LEFT;

import hu.elte.progtech.legion.soldier.model.Hand;

public class Russian extends Soldier {

    @Override
    public boolean guess(Soldier possessor) {
        return possessor instanceof American ? true : super.guess(possessor);
    }

    @Override
    protected Hand getChoice(Soldier possessor) {
        return LEFT;
    }

    @Override
    protected Hand shuffle() {
        return LEFT;
    }

}
