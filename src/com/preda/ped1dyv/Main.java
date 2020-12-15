package com.preda.ped1dyv;

public class Main {

    public static void main(String[] args) {
        TournamentArguments arguments = new TournamentArguments(args);

        DivideAndConquerB divideAndConquerB = new DivideAndConquerB(arguments.getPlayers(), arguments.isRecursiveFlag(),
                arguments.isNamesFlag(), arguments.getNames());

        if(arguments.getPlayers() > 1){
            divideAndConquerB.arrangeTournament();
        }

    }
}
