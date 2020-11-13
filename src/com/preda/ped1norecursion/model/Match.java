package com.preda.ped1norecursion.model;

public class Match {

    private Player opponent;
    private int day;

    public Match(Player opponent, int day) {
        this.opponent = opponent;
        this.day = day;
    }


    public Player getOpponent() {
        return opponent;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Match{" +
                "opponent=" + opponent.getName() +
                ", day=" + day +
                '}';
    }
}
