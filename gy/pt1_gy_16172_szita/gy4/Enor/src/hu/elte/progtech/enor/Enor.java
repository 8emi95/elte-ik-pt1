package hu.elte.progtech.enor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

enum Status {
    NORM, ABNORM
}

public class Enor {

    public static class Match {
        private String home;
        private String away;
        private int homeGoals;
        private int awayGoals;

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getAway() {
            return away;
        }

        public void setAway(String away) {
            this.away = away;
        }

        public int getHomeGoals() {
            return homeGoals;
        }

        public void setHomeGoals(int homeGoals) {
            this.homeGoals = homeGoals;
        }

        public int getAwayGoals() {
            return awayGoals;
        }

        public void setAwayGoals(int awayGoals) {
            this.awayGoals = awayGoals;
        }

    }

    private Status sx = Status.NORM;
    private Match dx;
    private Scanner x;

    public Enor(String fileName) {
        try {
            x = new Scanner(new File(fileName));
            dx = new Match();
        } catch (FileNotFoundException e) {
            sx = Status.ABNORM;
        }
    }

    public void First() {
        Next();
    }

    public boolean End() {
        return Status.ABNORM.equals(sx);
    }

    public void Next() {
        if (x.hasNext()) {
            String line = x.nextLine();
            String[] parts = line.split(" ");
            dx.setHome(parts[0]);
            dx.setAway(parts[1]);
            String[] goals = parts[2].split("-");
            dx.setHomeGoals(Integer.parseInt(goals[0]));
            dx.setAwayGoals(Integer.parseInt(goals[1]));
        } else {
            sx = Status.ABNORM;
            x.close();
        }
    }

    public Match Current() {
        return dx;
    }

}
