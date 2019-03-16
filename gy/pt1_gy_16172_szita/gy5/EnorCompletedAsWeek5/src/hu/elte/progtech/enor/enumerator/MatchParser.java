package hu.elte.progtech.enor.enumerator;

import hu.elte.progtech.enor.domain.Match;

public class MatchParser extends Parser<Match> {

    @Override
    public Match parse(String line) {
        Match match = new Match();
        String[] parts = line.split(" ");
        match.setHome(parts[0]);
        match.setAway(parts[1]);
        String[] goals = parts[2].split("-");
        match.setHomeGoals(Integer.parseInt(goals[0]));
        match.setAwayGoals(Integer.parseInt(goals[1]));
        return match;
    }

}
