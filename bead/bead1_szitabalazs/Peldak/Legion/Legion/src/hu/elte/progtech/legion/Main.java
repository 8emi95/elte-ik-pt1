package hu.elte.progtech.legion;

import java.io.IOException;
import java.util.NoSuchElementException;

import hu.elte.progtech.legion.soldier.Soldier;

public class Main {

    private static final String INPUT_FILE = "input.txt";

    private static final String FILE_ERROR = "Hibas vagy nem letezo fajl.";
    private static final String ALL_HAVE_POSSESSED = "Mindenkinel volt legalabb egyszer a salata.";
    private static final String NOT_ALL_HAVE_POSSESSED = "Nem volt mindenkinel a salata.";

    public static void main(String[] args) {
        try (LegionParser parser = new LegionParser(INPUT_FILE)) {
            Legion legion = parser.parse();
            play(legion);
            answer(legion);
        } catch (IOException | NumberFormatException | NoSuchElementException e) {
            System.err.println(FILE_ERROR);
        }
    }

    private static void play(Legion legion) {
        for (int i = 0; i < legion.getRounds(); ++i) {
            Soldier guesser = legion.getGuesser();
            if (guesser.guess(legion.getPossessor())) {
                legion.setPossessor(guesser);
            }
        }
    }

    private static void answer(Legion legion) {
        if (allHavePossessed(legion)) {
            System.out.print(ALL_HAVE_POSSESSED);
        } else {
            System.out.print(NOT_ALL_HAVE_POSSESSED);
        }
    }

    private static boolean allHavePossessed(Legion legion) {
        for (Soldier soldier : legion.getSoldiers()) {
            if (!soldier.hasPossessed()) {
                return false;
            }
        }
        return true;
    }

}
