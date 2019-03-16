package hu.elte.progtech.enor;

import hu.elte.progtech.enor.domain.Match;
import hu.elte.progtech.enor.enumerator.Enor;
import hu.elte.progtech.enor.enumerator.MatchParser;

public class Main {
    public static String FILE_NAME = "resources/matches.txt";

    public static void main(String args[]) {
        Enor<Match> t = new Enor<>(FILE_NAME, new MatchParser());
        t.First();
        int sumOfGoals = 0;
        if (!t.End()) {
            System.out.println(">" + t.Current());
            sumOfGoals = totalGoals(t.Current());
            Match matchWithMostGoals = t.Current();
            int mostGoals = totalGoals(t.Current());
            for (t.Next(); !t.End(); t.Next()) {
                int totalGoalsOfMatch = totalGoals(t.Current());
                sumOfGoals += totalGoalsOfMatch;
                if (mostGoals < totalGoalsOfMatch) {
                    mostGoals = totalGoalsOfMatch;
                }
                System.out.println(">" + t.Current());
            }
            System.out.println(matchWithMostGoals.getHome() + " " + matchWithMostGoals.getAway());
        }
        System.out.println(sumOfGoals);
    }

    private static int totalGoals(Match m) {
        return m.getHomeGoals() + m.getAwayGoals();
    }

}
