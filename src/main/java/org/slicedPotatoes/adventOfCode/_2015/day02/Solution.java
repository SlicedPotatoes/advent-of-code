package org.slicedPotatoes.adventOfCode._2015.day02;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day02/input.txt");

        int part1 = 0;
        int part2 = 0;

        for(String line : lines) {
            int[] e = Arrays.stream(line.split("x")).mapToInt(Integer::parseInt).sorted().toArray();

            // Calcul de l'aire des différentes face du cadeau
            int s1 = e[0]*e[1];
            int s2 = e[0]*e[2];
            int s3 = e[1]*e[2];

            // Papier nécéssaire pour emballer le cadeau
            part1 += 2*s1 + 2*s2 + 2*s3 + s1;
            // Ruban nécéssaire pour emballer le cadeau
            part2 += e[0]*e[1]*e[2] + 2*e[0]+2*e[1];
        }

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
