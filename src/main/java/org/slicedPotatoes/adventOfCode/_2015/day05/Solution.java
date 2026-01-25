package org.slicedPotatoes.adventOfCode._2015.day05;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Renvoie vrai si une chaine respect les critères suivant, sinon false.<br>
     * - Contient au moins 3 voyelles<br>
     * - S'il y a deux caractères consécutifs identiques<br>
     * - Si elle ne contient pas les séquences suivantes : "ab", "cd", "pq", "xy"<br>
     *
     * @param s La chaine à vérifier
     * @return true ou false en fonction de si elle respecte les critères
     */
    public static boolean isNiceStringPart1(String s) {
        List<String> illegal = List.of("ab", "cd", "pq", "xy");
        String vowels = "aeiou";

        int countVowels = 0;
        boolean twiceInRow = false;

        char previousChar = ' ';

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            // Si voyelle, incrémente le compteur
            if(vowels.indexOf(curr) != -1) { countVowels++; }
            // Si même caractère consécutif, mettre le flag sur true
            if(curr == previousChar) { twiceInRow = true; }
            // Si séquence illegal, renvoyer false
            if(illegal.contains( String.valueOf(previousChar) + curr )) { return false; }

            previousChar = curr;
        }

        return countVowels >= 3 && twiceInRow;
    }

    /**
     * Renvoie vrai si une chaine respect les critères suivant, sinon false.<br>
     * - Contient une paire de caractères qui apparait deux fois dans la chaine et qui ne se chevauche pas (Ex : xyaaaxy → xy répété deux fois.) <br>
     * - Contient deux caractères identiques séparés par un caractère quelconque (Ex : xyx, aaa)
     *
     * @param s La chaine à vérifier
     * @return true ou false en fonction de si elle respecte les critères
     */
    public static boolean isNiceStringPart2(String s) {
        // Contient les paires avec l'index de fin de la première occurence de celle-ci
        Map<String, Integer> pairs = new HashMap<>();

        // Flags des conditions
        boolean cond1 = false;
        boolean cond2 = false;

        char previous = ' ';
        char previous2 = ' ';

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            String currPair = String.valueOf(previous) + curr;

            // Si la paire est contenue dans la hashmap, on vérifie si elle ne chevauche pas l'actuelle paire
            // Si elle n'est pas contenue, on l'ajoute.
            if (pairs.containsKey(currPair)) {
                if(pairs.get(currPair) < i - 1) { cond1 = true; }
            }
            else { pairs.put(currPair, i); }

            if (previous2 == curr) { cond2 = true; }

            previous2 = previous;
            previous = curr;
        }

        return cond1 && cond2;
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day05/input.txt");

        int part1 = 0;
        int part2 = 0;

        for(String s : lines) {
            if (isNiceStringPart1(s)) { part1++; }
            if (isNiceStringPart2(s)) { part2++; }
        }

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
