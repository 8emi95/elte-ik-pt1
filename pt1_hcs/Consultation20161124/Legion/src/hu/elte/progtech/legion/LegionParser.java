package hu.elte.progtech.legion;

import static hu.elte.progtech.legion.soldier.model.Nation.ENG;
import static hu.elte.progtech.legion.soldier.model.Nation.FRA;
import static hu.elte.progtech.legion.soldier.model.Nation.RUS;
import static hu.elte.progtech.legion.soldier.model.Nation.USA;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import hu.elte.progtech.legion.soldier.American;
import hu.elte.progtech.legion.soldier.English;
import hu.elte.progtech.legion.soldier.French;
import hu.elte.progtech.legion.soldier.Russian;
import hu.elte.progtech.legion.soldier.Soldier;

public class LegionParser implements Closeable {

    private static final char ASTERISK = '*';
    private static final String NATION_FORMAT_ERROR = "Could not parse a nationality from %s";
    private static final String ONE_POSSESSOR_ERROR = "There is not exactly one initial possessor present";
    private static final String ONE_SOLDIER_ERROR = "Only one soldier at the table";

    private Scanner scanner;

    public LegionParser(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
    }

    public Legion parse() throws NoSuchElementException, NumberFormatException {
        Legion legion = new Legion();
        addRounds(legion);
        addSoldiers(legion);
        return legion;
    }

    private void addRounds(Legion legion) throws NoSuchElementException, NumberFormatException {
        String line = scanner.nextLine();
        legion.setRounds(Integer.parseInt(line));
    }

    private void addSoldiers(Legion legion) throws NoSuchElementException {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int indexOfAsterisk = line.indexOf(ASTERISK);
            Soldier soldier = createSoldier(line, indexOfAsterisk);
            legion.addSoldier(soldier);
            setPossessor(legion, indexOfAsterisk, soldier);
        }
        checkSoldiers(legion);
    }

    private Soldier createSoldier(String line, int indexOfAsterisk) {
        if (isInitialPossessor(indexOfAsterisk)) {
            line = line.substring(0, indexOfAsterisk);
        }
        return createSoldier(line);
    }

    private boolean isInitialPossessor(int indexOfAsterisk) {
        return indexOfAsterisk != -1;
    }

    private Soldier createSoldier(String nation) throws NoSuchElementException {
        if (ENG.name().equals(nation)) {
            return new English();
        } else if (USA.name().equals(nation)) {
            return new American();
        } else if (RUS.name().equals(nation)) {
            return new Russian();
        } else if (FRA.name().equals(nation)) {
            return new French();
        } else {
            throw new NoSuchElementException(String.format(NATION_FORMAT_ERROR, nation));
        }
    }

    private void setPossessor(Legion legion, int indexOfAsterisk, Soldier soldier) {
        if (isInitialPossessor(indexOfAsterisk)) {
            legion.setPossessor(soldier);
        }
    }

    private void checkSoldiers(Legion legion) throws NoSuchElementException {
        if (!isThereExactlyOnePossessor(legion)) {
            throw new NoSuchElementException(ONE_POSSESSOR_ERROR);
        }
        if (legion.getSoldiers().size() < 2) {
            throw new NoSuchElementException(ONE_SOLDIER_ERROR);
        }
    }

    private boolean isThereExactlyOnePossessor(Legion legion) {
        return 1 == legion.getSoldiers().stream().filter(Soldier::hasPossessed).count();
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }

}
