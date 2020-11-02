package com.preda.ped1.model;

import java.util.List;

public class Tournament {

    int numberOfDays;
    List<Player> players;

    public Tournament(int numberOfDays, List<Player> players) {
        this.numberOfDays = numberOfDays;
        this.players = players;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
