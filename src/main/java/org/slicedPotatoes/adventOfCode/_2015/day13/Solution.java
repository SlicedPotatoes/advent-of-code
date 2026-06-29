package org.slicedPotatoes.adventOfCode._2015.day13;

import org.slicedPotatoes.adventOfCode.utils.ExecutionTime;
import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    /**
     * Il y a n personnes, et pour chaque personne, il y a (n-1) lignes.
     * <br>
     * Cette fonction retourne, à partir du nombre de lignes, le nombre de personnes.
     */
    public static int findNbPeople(int nbLine) {
        int n = (int)((1 + Math.sqrt(1 + 4 * nbLine)) / 2);

        if(n * (n-1) == nbLine) {
            return n;
        }

        throw new RuntimeException("sad");
    }

    /**
     * Récupérer l'identifiant d'une personne depuis la map à partir de son nom
     * <br>
     * Si celui-ci n'existe pas, il est créé
     */
    public static int getPeople(Map<String, Integer> peopleMap, String name) {
        if (peopleMap.containsKey(name)) {
            return peopleMap.get(name);
        }

        int p = peopleMap.size();
        peopleMap.put(name, p);
        return p;
    }

    /**
     * Maximiser le score happiness pour une Liste de peoples avec du backtracking
     *
     * @param nbPeoples Nombre de personnes à placer
     * @param happiness Matrice d'happiness
     * @param see       Personne placée
     * @param current   Arrangement courant partiel
     * @param currIndex Index actuel de current
     * @param currScore Score actuel
     * @return          Score maximisé
     */
    public static int maximiseArrangementScore(int nbPeoples, int[][] happiness, boolean[] see, int[] current, int currIndex, int currScore) {
        if (nbPeoples == currIndex) {
            // Calcul du score final
            currScore += happiness[0][current[currIndex - 1]];
            currScore += happiness[current[currIndex - 1]][0];
            return currScore;
        }

        int score = Integer.MIN_VALUE;

        for(int i = 0; i < nbPeoples; i++) {
            if(see[i]) { continue; }

            current[currIndex] = i;
            see[i] = true;

            // Calcul du score intermédiaire
            int nextScore = currScore + happiness[current[currIndex - 1]][i];
            nextScore += happiness[i][current[currIndex - 1]];

            score = Math.max(score, maximiseArrangementScore(nbPeoples, happiness, see, current, currIndex + 1, nextScore));

            see[i] = false;
        }

        return score;
    }

    public static int part1(int nbPeoples, int[][] happiness) {
        boolean[] see = new boolean[nbPeoples];
        see[0] = true;

        int[] current = new int[nbPeoples];

        return maximiseArrangementScore(nbPeoples, happiness, see, current, 1, 0);
    }

    public static int part2(int nbPeoples, int[][] happiness) {
        return part1(nbPeoples + 1, happiness);
    }

    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day13/input.txt");

        int nbPeople = findNbPeople(content.size());

        Map<String, Integer> peopleMap = new HashMap<>();       // Map pour faire les liens entre un nom et l'indice de la personne
        int[][] happiness = new int[nbPeople+1][nbPeople+1];    // Matrice où chaque case représente l'happiness entre une personne i et j

        // Parsing
        for (String line : content) {
            String[] splitedLine = line.split(" ");

            String name1 = splitedLine[0];
            boolean isGain = splitedLine[2].equals("gain");
            int value = Integer.parseInt(splitedLine[3]);
            String name2 = splitedLine[10].replaceAll("\\.$", "");

            int p1 = getPeople(peopleMap, name1);
            int p2 = getPeople(peopleMap, name2);

            happiness[p1][p2] = value * (isGain ? 1 : -1);
        }

        AtomicInteger part1 = new AtomicInteger();
        AtomicInteger part2 = new AtomicInteger();

        ExecutionTime.measure(() -> part1.set(part1(nbPeople, happiness)));
        ExecutionTime.measure(() -> part2.set(part2(nbPeople, happiness)));

        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
