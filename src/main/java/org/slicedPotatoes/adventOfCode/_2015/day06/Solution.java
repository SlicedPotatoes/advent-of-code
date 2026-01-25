package org.slicedPotatoes.adventOfCode._2015.day06;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Fonction qui permet d'appliquer les opérations sur la grille de lumière
     *
     * @param todo Opération a effectuer
     * @param start Index de départ inclusif
     * @param end Index de fin inclusif
     * @param lights Matrice de lumière
     * @param f Lambda expression, pour effectuer des actions différente en fonction de l'opération (différent pour la partie 1 et 2)
     */
    public static void processLine(String todo, int[] start, int[] end, int[][] lights, Operation f) {
        for(int y = start[0]; y <= end[0]; y++) {
            for(int x = start[1]; x <= end[1]; x++) {
                f.apply(x, y, todo, lights);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day06/input.txt");

        int[][] Mpart1 = new int[1000][1000];
        int[][] Mpart2 = new int[1000][1000];

        for(String line : lines) {
            String[] instruction = line.split(" ");

            // Récupère l'action à effectuer
            String todo = instruction[0].equals("toggle") ? "toggle" : instruction[1];

            // Récupère les indices de début et fin
            int[] start = Arrays.stream(instruction[todo.equals("toggle") ? 1 : 2].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(instruction[todo.equals("toggle") ? 3 : 4].split(",")).mapToInt(Integer::parseInt).toArray();

            processLine(todo, start, end, Mpart1, (x, y, _todo, lights) -> {
                if(_todo.equals("toggle")) { lights[y][x] = lights[y][x] == 1 ? 0 : 1; }
                else { lights[y][x] = _todo.equals("on") ? 1 : 0; }
            });

            processLine(todo, start, end, Mpart2, (x, y, _todo, lights) -> {
                if(_todo.equals("off")) { if(lights[y][x] > 0) { lights[y][x]--; } }
                else { lights[y][x] += _todo.equals("on") ? 1 : 2; }
            });
        }

        int part1 = 0;
        int part2 = 0;

        // Récupère les résultats finaux
        for(int y = 0; y < 1000; y++) {
            for(int x = 0; x < 1000; x++) {
                part1 += Mpart1[y][x];
                part2 += Mpart2[y][x];
            }
        }

        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
