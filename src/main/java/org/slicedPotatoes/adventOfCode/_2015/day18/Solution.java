package org.slicedPotatoes.adventOfCode._2015.day18;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    private static final int GRID_SIZE = 100;
    private static final int[] dx = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    private static final int[] dy = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};

    /**
     * Pour la partie 2, fix les coins allumés
     */
    public static void blocCornerPart2(boolean[][] grid) {
        grid[0][0] = true;
        grid[0][grid[0].length - 1] = true;
        grid[grid.length - 1][0] = true;
        grid[grid.length - 1][grid[0].length - 1] = true;
    }

    /**
     * Fait une deep copy d'une grille de boolean
     */
    public static boolean[][] deepClone(boolean[][] grid) {
        boolean[][] result = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = grid[i][j];
            }
        }

        return result;
    }

    /**
     * Simule la grille suivante suivant les règles du jeu de la vie.
     *
     * @param grid Grille d'entrée
     * @return Grille de sortie
     */
    public static boolean[][] nextGameOfLife(boolean[][] grid) {
        boolean[][] next = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int count = 0;

                for (int d = 0; d < 8; d++) {
                    int x = j + dx[d];
                    int y = i + dy[d];

                    if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x]) {
                        count++;
                    }
                }

                if (grid[i][j] && count >= 2 && count <= 3) {
                    next[i][j] = true;
                } else if (!grid[i][j] && count == 3) {
                    next[i][j] = true;
                }
            }
        }

        return next;
    }

    /**
     * Simule les n parties, et renvoie le nombre de lumières allumées.
     *
     * @param grid    Grille de départ
     * @param n       Nombre d'itération
     * @param isPart2 Flag pour la partie 2
     * @return Nombre de lumières allumé
     */
    public static int process(boolean[][] grid, int n, boolean isPart2) {
        boolean[][] curr = deepClone(grid);

        if (isPart2) {
            blocCornerPart2(curr);
        }

        // Simule les n parties
        for (int s = 0; s < n; s++) {
            curr = nextGameOfLife(curr);
            if (isPart2) {
                blocCornerPart2(curr);
            }
        }

        int result = 0;

        // Compte le nombre de lumières allumé
        for (boolean[] booleans : curr) {
            for (boolean b : booleans) {
                if (b) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day18/input.txt");

        boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = content.get(i).charAt(j) == '#';
            }
        }

        int part1 = process(grid, 100, false);
        int part2 = process(grid, 100, true);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
