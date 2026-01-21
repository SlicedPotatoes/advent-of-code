package org.slicedPotatoes.adventOfCode._2015.day05;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.List;

public class Part1 {
    public static boolean isNiceString(String s) {
        List<String> illegal = List.of("ab", "cd", "pq", "xy");
        String vowels = "aeiou";

        int countVowels = 0;
        boolean twiceInRow = false;

        char previousChar = ' ';

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(vowels.indexOf(curr) != -1) { countVowels++; }
            if(curr == previousChar) { twiceInRow = true; }
            if(illegal.contains( "" + previousChar + curr )) { return false; }

            previousChar = curr;
        }

        return countVowels >= 3 && twiceInRow;
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
