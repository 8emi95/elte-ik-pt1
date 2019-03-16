package hu.elte.progtech.legion.soldier;

import static hu.elte.progtech.legion.soldier.model.Hand.CHEAT;

import hu.elte.progtech.legion.soldier.model.Hand;

public class American extends Soldier {

    @Override
    protected Hand shuffle() {
        return quarterProbability() ? CHEAT : super.shuffle();
    }

    private boolean quarterProbability() {
        return random.nextInt(4) == 0;
    }

}
