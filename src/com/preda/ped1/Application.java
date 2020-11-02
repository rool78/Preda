package com.preda.ped1;

import com.preda.ped1.model.Match;
import com.preda.ped1.model.Player;
import com.preda.ped1.model.Tournament;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private Tournament tournament;
    int numberOfPlayers;
    int days;

    public void launch(int n) {
        numberOfPlayers = n;
        days = n - 1;

        //TODO Creamos el torneo, si nos pasan el fichero con los nombres de los jugadores, les daremos nombre, si no, no.
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = new Player("J" + i);
            players.add(player);
        }
        tournament = new Tournament(days, players);
        arrangeTournament();
        printTable();
    }

    private void arrangeTournament() {
        List<Player> players = tournament.getPlayers();
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < numberOfPlayers; j++) {
                if (i != j) {
                    Player player = players.get(i);
                    Player opponent = players.get(j);
                    List<Match> matchesPlayer = player.getMatches();
                    List<Match> matchesOpponent = opponent.getMatches();

                    boolean available = true;
                    for (int k = 0; k < matchesPlayer.size(); k++) {
                        if (matchesPlayer.get(k).getOpponent().equals(opponent)) {
                            available = false;
                        }
                    }
                    for (int k = 0; k < matchesOpponent.size(); k++) {
                        if (matchesOpponent.get(k).getOpponent().equals(player)) {
                            available = false;
                        }
                    }
                    if (available) {
                        int dayAvailable = findDay(player, opponent);
                        player.setMatch(new Match(opponent, dayAvailable));
                        opponent.setMatch(new Match(player, dayAvailable));
                        System.out.println("Partido asignado: " + player.getName() + " vs " + opponent.getName() + " dia: " + dayAvailable);
                    }
                }
            }
        }
    }

    private int findDay(Player player, Player opponent) {
        boolean found = false;
        int counter = 1;
        while (!found && counter <= days) {
            boolean playerIsAvailable = true;
            boolean opponentIsAvailable = true;
            for (Match m : player.getMatches()) {
                if (m.getDay() == counter) {
                    playerIsAvailable = false;
                }
            }
            for (Match m : opponent.getMatches()) {
                if (m.getDay() == counter) {
                    opponentIsAvailable = false;
                }
            }
            if (playerIsAvailable && opponentIsAvailable) {
                found = true;
                return counter;
            }
            counter++;
        }
        return counter;
    }

    private void printTable() {
        System.out.print("   ");
        for (int i = 1; i <= days; i++) {
            System.out.print("d" + i + " ");
        }
        System.out.println();
        for (Player p : tournament.getPlayers()) {
            System.out.print(p.getName());
            for (int i = 0; i < p.getMatches().size(); i++) {
                printMatch(p.getMatches(), i + 1);
            }
            System.out.println();
        }
    }

    private void printMatch(List<Match> matches, int day) {
        for (Match m: matches) {
            if (m.getDay() == day) {
                System.out.print(" " + m.getOpponent().getName());
            }
        }
    }

    private void printPlayers() {
        System.out.println("Nombre Jugadores:");

        for (Player p :
                tournament.getPlayers()
        ) {
            System.out.println(p.getName());
        }
    }

}
