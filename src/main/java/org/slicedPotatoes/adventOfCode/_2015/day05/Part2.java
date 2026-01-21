package org.slicedPotatoes.adventOfCode._2015.day05;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.*;

public class Part2 {
    public static boolean isNiceString(String s) {
        // Contient les paires avec l'index de fin de la première occurence de celle-ci
        Map<String, Integer> pairs = new HashMap<>();

        boolean cond1 = false;
        boolean cond2 = false;

        char previous = ' ';
        char previous2 = ' ';

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            String currPair = "" + previous + curr;

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

        int res = 0;

        for(String s : lines) {
            if (isNiceString(s)) { res++; }
        }

        System.out.println("Résultat: " + res);
    }
}
