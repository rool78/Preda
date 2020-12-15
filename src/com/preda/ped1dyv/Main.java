package com.preda.ped1dyv;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TournamentArguments arguments = new TournamentArguments(args);

        DivideAndConquerB divideAndConquerB = new DivideAndConquerB(arguments.getMaxPlayers(), arguments.isRecursiveFlag(),
                arguments.isNamesFlag(), arguments.getNames());

        divideAndConquerB.arrangeTournament();
    }
}
