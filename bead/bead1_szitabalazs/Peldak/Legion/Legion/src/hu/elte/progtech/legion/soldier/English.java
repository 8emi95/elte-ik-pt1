package hu.elte.progtech.legion.soldier;

import static hu.elte.progtech.legion.soldier.model.Hand.LEFT;

import hu.elte.progtech.legion.soldier.model.Hand;

public class English extends Soldier {

    @Override
    protected Hand getChoice(Soldier possessor) {
        return possessor instanceof French ? LEFT : super.getChoice(possessor);
    }

}
