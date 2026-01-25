package org.slicedPotatoes.adventOfCode._2015.day03;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Recherche le nombre de maisons unique visité à partir d'une liste de mouvement à effectuer
     *
     * @param content Liste des mouvements
     * @param n Nombre d'entité
     * @return Nombre de maisons unique visité
     */
    public static int process(String content, int n) {
        // Ensemble des maisons uniques visité
        Set<Point> set = new HashSet<>();

        // Coordonné actuel de chaque entité
        int[] x = new int[n];
        int[] y = new int[n];

        // Ajout du point (0,0)
        set.add(new Point(0, 0));

        for(int i = 0; i < content.length(); i++) {
            // Effectuer le déplacement pour l'entité i % n
            switch (content.charAt(i)) {
                case '>':
                    x[i % n]++;
                    break;
                case '<':
                    x[i % n]--;
                    break;
                case 'v':
                    y[i % n]++;
                    break;
                case '^':
                    y[i % n]--;
                    break;
            }

            set.add(new Point(x[i % n], y[i % n]));
        }

        return set.size();
    }

    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day03/input.txt");

        int part1 = process(content, 1);
        int part2 = process(content, 2);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
