package hu.elte.progtech.legion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.elte.progtech.legion.soldier.Soldier;

public class Legion {

    private int rounds;
    private Soldier possessor;
    private List<Soldier> soldiers = new ArrayList<>();

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Soldier getPossessor() {
        return possessor;
    }

    public void setPossessor(Soldier possessor) {
        this.possessor = possessor;
        possessor.setPossessed();
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public Soldier getGuesser() {
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(soldiers.size() - 1);
        if (index >= soldiers.indexOf(possessor)) {
            ++index;
        }
        return soldiers.get(index);
    }

}
