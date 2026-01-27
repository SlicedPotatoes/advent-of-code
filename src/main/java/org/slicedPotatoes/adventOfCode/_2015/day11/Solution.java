package org.slicedPotatoes.adventOfCode._2015.day11;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static String increment(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        while(i >= 0 && s.charAt(i) == 'z') {
            sb.append('a');
            i--;
        }

        sb.append( Character.toChars(s.charAt(i--) + 1) );

        for(; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }

    public static boolean isValidPassword(String s) {
        Set<Character> illegal = Set.of('i', 'o', 'l');

        char[] previous = {' ', ' '};

        boolean increasingSequence = false;
        Set<String> pair = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(illegal.contains(c)) {
                return false;
            }

            if(previous[0] == previous[1] - 1 && previous[0] == c - 2) {
                increasingSequence = true;
            }

            if(previous[1] == c) {
                pair.add(String.valueOf(c) + c);
            }

            previous[0] = previous[1];
            previous[1] = c;
        }

        return increasingSequence && pair.size() >= 2;
    }

    public static String nextValidPassword(String s) {
        do {
            s = increment(s);
        } while (!isValidPassword(s));

        return s;
    }

    public static void main(String[] args) throws IOException {
        String input = ReadFile.getFullFile("_2015/day11/input.txt");

        String part1 = nextValidPassword(input);
        String part2 = nextValidPassword(part1);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
