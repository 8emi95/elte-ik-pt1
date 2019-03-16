package hu.elte.progtech.legion.soldier;

import static hu.elte.progtech.legion.soldier.model.Hand.LEFT;
import static hu.elte.progtech.legion.soldier.model.Hand.RIGHT;

import hu.elte.progtech.legion.soldier.model.Hand;

public class French extends Soldier {

    private Hand lastHand;

    @Override
    public boolean guess(Soldier possessor) {
        if (possessor instanceof French) {
            return true;
        } else if (possessor instanceof English) {
            return false;
        }
        return super.guess(possessor);
    }

    @Override
    protected Hand shuffle() {
        if (lastHand == null) {
            lastHand = getFiftyFiftyHand();
        } else {
            lastHand = LEFT.equals(lastHand) ? RIGHT : LEFT;
        }
        return lastHand;
    }

}
