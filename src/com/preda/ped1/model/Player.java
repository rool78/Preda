package com.preda.ped1.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Match> matches;

    public Player(String name) {
        this.name = name;
        this.matches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatch(Match match) {
        matches.add(match);
    }

}
