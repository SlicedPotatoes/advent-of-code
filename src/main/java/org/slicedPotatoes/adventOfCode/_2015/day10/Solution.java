package org.slicedPotatoes.adventOfCode._2015.day10;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;

public class Solution {
    public static String lookAndSaySequence(String s) {
        StringBuilder stb = new StringBuilder();

        char c = s.charAt(0);
        int count = 1;

        for(int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if(curr == c) {
                count++;
                continue;
            }

            stb.append(count).append(c);
            c = curr;
            count = 1;
        }

        stb.append(count).append(c);

        return stb.toString();
    }

    public static void main(String[] args) throws IOException {
        String part1 = ReadFile.getFullFile("_2015/day10/input.txt");

        for(int i = 0; i < 40; i++) {
            part1 = lookAndSaySequence(part1);
        }

        String part2 = part1;

        for(int i = 0; i < 10; i++) {
            part2 = lookAndSaySequence(part2);
        }

        System.out.println("Part1: " + part1.length());
        System.out.println("Part2: " + part2.length());
    }
}
