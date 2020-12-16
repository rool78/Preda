package com.preda.ped1dyv;

import java.util.ArrayList;
import java.util.List;

public class DivideAndConquerB {

    private boolean recursiveFlag = false;
    private boolean namesFlag = false;
    private List<String> names = new ArrayList<>();
    private int maxPlayers;
    private int[][] table;

    public DivideAndConquerB(int maxPlayers, boolean recursiveFlag, boolean namesFlag, List<String> names) {
        this.recursiveFlag = recursiveFlag;
        this.namesFlag = namesFlag;
        this.names = names;
        this.maxPlayers = maxPlayers;
        this.table = new int[maxPlayers + 2][maxPlayers + 2];
    }

    public void arrangeTournament() {
        long startTime = System.nanoTime();
        arrangeTournamentB(maxPlayers, table);
        long stopTime = System.nanoTime();
        //Quitar comentarios para ver tiempo ejecucion algoritmo
//        System.out.print("Recursion time(ns): ");
//        System.out.print(stopTime - startTime);
        printTournament();
    }

    private void arrangeTournamentB(int n, int[][] table) {
        int player, day, m;

        if (n == 2) {
            table[1][1] = 2;
            table[2][1] = 1;
        } else if (n % 2 != 0) {
            if (recursiveFlag) System.out.println("##@@--Traza recursividad. valor n: [" + n + "]");
            arrangeTournamentB(n + 1, table);
            for (player = 1; player <= n; player++) {
                for (day = 1; day <= n; day++) {
                    if (table[player][day] == n + 1) {
                        table[player][day] = 0;
                    }
                }
            }
        } else { //n par
            m = n / 2;
            if (recursiveFlag) System.out.println("##@@--Traza recursividad. valor n: [" + n + "]");
            arrangeTournamentB(m, table); //s. izq
            if (m % 2 == 0) { //m par
                for (player = m + 1; player <= n; player++) {
                    for (day = 1; day <= m - 1; day++) {
                        table[player][day] = table[player - m][day] + m;
                    }
                }
                for (player = 1; player <= m; player++) {
                    for (day = m; day <= n - 1; day++) {
                        if (player + day <= n) {
                            table[player][day] = player + day;
                        } else {
                            table[player][day] = player + day - m;
                        }
                    }
                }
                for (player = m + 1; player <= n; player++) {
                    for (day = m; day <= n - 1; day++) {
                        if (player > day) {
                            table[player][day] = player - day;
                        } else {
                            table[player][day] = (player + m) - day;
                        }
                    }
                }
            } else { //m impar
                for (player = m + 1; player <= n; player++) {
                    for (day = 1; day <= m; day++) {
                        if (table[player - m][day] == 0) {
                            table[player][day] = 0;
                        } else {
                            table[player][day] = table[player - m][day] + m;
                        }
                    }
                }
                for (player = 1; player <= m; player++) {
                    for (day = 1; day <= m; day++) {
                        if (table[player][day] == 0) {
                            table[player][day] = player + m;
                            table[player + m][day] = player;
                        }
                    }
                }
                for (player = 1; player <= m; player++) {
                    for (day = m + 1; day <= n - 1; day++) {
                        if (player + day <= n) {
                            table[player][day] = player + day;
                        } else {
                            table[player][day] = player + day - m;
                        }
                    }
                }
                for (player = m + 1; player <= n; player++) {
                    for (day = m + 1; day <= n - 1; day++) {
                        if (player > day) {
                            table[player][day] = player - day;
                        } else {
                            table[player][day] = (player + m) - day;
                        }
                    }
                }
            }
        }
    }

    private void printTournament() {
        int days = maxPlayers % 2 == 0 ? maxPlayers - 1 : maxPlayers;
        int padding = findLongestName() + 3;
        if (namesFlag) {
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= days; i++) {
                System.out.printf("%-" + padding + "s", "d" + i + " ");
            }
            System.out.println();
            for (int i = 1; i < table.length - 1; i++) {
                System.out.printf("%-" + padding + "s", names.get(i));
                for (int j = 1; j <= days; j++) {
                    System.out.printf("%-" + padding + "s", names.get(table[i][j]));
                }
                System.out.println();
            }
        } else {
            padding = 5;
            System.out.print("     ");
            for (int i = 1; i <= days; i++) {
                System.out.printf("%-" + padding + "s", "d" + i + " ");
            }
            System.out.println();
            for (int i = 1; i < table.length - 1; i++) {
                System.out.printf("%-" + padding + "s", "J" + i);
                for (int j = 1; j <= days; j++) {
                    System.out.printf("%-" + padding + "s", table[i][j]);
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