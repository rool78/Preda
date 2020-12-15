package com.preda.ped1dyv;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TournamentArguments {

    private boolean recursiveFlag = false;
    private boolean namesFlag = false;
    private final List<String> names = new ArrayList<>();
    private int maxPlayers;

    public TournamentArguments(String[] args) {
        processArguments(args);
    }

    private void processArguments(String[] args) {
        for (String arg : args) {
            if (arg.equals("-t")) {
                recursiveFlag = true;
            }
            if (arg.equals("-h")) {
                System.out.println("SINTAXIS:torneo[-t] [-h] n [fichero entrada]");
                System.out.println("-t Traza la parametrización de cada invocación recursiva");
                System.out.println("-h Muestra esta ayuda");
                System.out.println("n Número de jugadores");
                System.out.println("[fichero entrada] Listado de los nombres de los jugadores del torneo");
                return;
            }
            if (StringUtils.isNumeric(arg)) {
                maxPlayers = Integer.parseInt(arg);
            }
            if (arg.contains(".txt")) {
                namesFlag = true;
                names.add("P");
                String filePath = new File("").getAbsolutePath();
                try (BufferedReader br = new BufferedReader(new FileReader(filePath + "\\" + arg))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        names.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRecursiveFlag() {
        return recursiveFlag;
    }

    public boolean isNamesFlag() {
        return namesFlag;
    }

    public List<String> getNames() {
        return names;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}