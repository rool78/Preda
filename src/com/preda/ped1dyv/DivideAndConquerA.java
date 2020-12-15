package com.preda.ped1dyv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideAndConquerA {

    private boolean recursiveFlag = false;
    private boolean namesFlag = false;
    private List<String> names = new ArrayList<>();
    private int maxPlayers;
    private int[][] table;

    public DivideAndConquerA(int maxPlayers, boolean recursiveFlag, boolean namesFlag, List<String> names) {
        this.maxPlayers = maxPlayers;
        this.recursiveFlag = recursiveFlag;
        this.namesFlag = namesFlag;
        this.names = names;
        this.table = new int[maxPlayers + 1][maxPlayers + 1];
    }

    public void arrangeTournamentPowerOfTwoPlayers() {
        arrangeTournamentPowerOfTwoPlayers(maxPlayers, table);
        System.out.println(Arrays.deepToString(table));
        printTournament();
    }

     private void arrangeTournamentPowerOfTwoPlayers(int n, int[][] table) {
        int player, day;

        if (n == 2) { //caso base
            table[1][1] = 2;
            table[2][1] = 1;
        } else {
            if (recursiveFlag) System.out.println("##@@--Traza recursividad. valor n: [" + n + "]");
            arrangeTournamentPowerOfTwoPlayers(n / 2, table);
            for (player = (n / 2) + 1; player <= n; player++) { //Inferior izquierdo
                for (day = 1; day <= (n / 2) - 1; day++) { //En definitiva, por cada jugador, recorremos los dias del cuadrante S.I.
                    table[player][day] = table[player - (n / 2)][day] + (n / 2); //Se suma n/2 del correcpondiente cuadrante S.I Para enfrentar a los jugadores superiores
                }
            }
            for (player = 1; player <= (n / 2); player++) { //Superior derecho
                for (day = n / 2; day <= n - 1; day++) {
                    if ((player + day) <= n) { //Enfrenta a los jugadores con menor y mayores numeros
                        table[player][day] = player + day;
                    } else {
                        table[player][day] = player + day - (n / 2);
                    }
                }
            }
            for (player = (n / 2) + 1; player <= n; player++) { //Inferior izquierdo
                for (day = n / 2; day <= n - 1; day++) {
                    if (player > day) { //Enfrenta a los jugadores de mayor numero contra los de menor numero
                        table[player][day] = player - day;
                    } else {
                        table[player][day] = (player + (n / 2) - day);
                    }
                }
            }
        }
    }

    private void printTournament() {
        int days = maxPlayers - 1;
        int padding = findLongestName() + 3;
        if (namesFlag) {
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= days; i++) {
                System.out.printf("%-"+ padding + "s", "d" + i + " ");
            }
            System.out.println();
            for (int i = 1; i < table.length; i++) {
                System.out.printf("%-"+ padding + "s", names.get(i));
                for (int j = 1; j <= days; j++) {
                    System.out.printf("%-"+ padding + "s", names.get(table[i][j]));
                }
                System.out.println();
            }
        } else {
            System.out.print("   ");
            for (int i = 1; i <= days; i++) {
                System.out.print("d" + i + " ");
            }
            System.out.println();
            for (int i = 1; i < table.length; i++) {
                System.out.print("J" + i);
                for (int j = 1; j <= days; j++) {
                    System.out.print("  " + table[i][j]);
                }
                System.out.println();
            }
        }
    }

    private int findLongestName() {
        int longest = 0;
        for (String s :
                names) {
            if (s.length() > longest)
            longest = s.length();
        }
        return longest;
    }

}
