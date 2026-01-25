package org.slicedPotatoes.adventOfCode._2015.day01;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day01/input.txt");

        int part1 = 0;
        int part2 = -1;

        for(int i = 0; i < content.length(); i++) {
            // Incrémenté de 1 si '('
            // Décrémenté de 1 si ')'
            part1 += content.charAt(i) == '(' ? 1 : -1;

            // Si on est a l'étage -1 pour la 1er fois
            if(part1 == -1 && part2 == -1) {
                part2 = i+1;
            }
        }

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
