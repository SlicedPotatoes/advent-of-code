package org.slicedPotatoes.adventOfCode._2015.day08;


import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.List;

public class Solution {

    /**
     * Calcul la longeur réel d'un string en mémoire
     *
     * @param s Chaine à analyser
     * @return Longeur en memoire de la chaine
     */
    public static int countInMemorySize(String s) {
        int size = 0;
        int flag = 0;

        for(int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);

            if(c == '\\') {
                if(flag == 0) { flag++; }
                else { flag = 0; }
            }
            if(c == '"' && flag == 1) {
                flag = 0;
            }
            else if(c == 'x' && flag == 1) {
                flag = 0;
                i+=2;
            }

            if(flag == 0) { size++; }
        }

        return size;
    }

    /**
     * Encode un string, "comme si on devait l'écrire dans du code"
     *
     * @param s Chaine à encoder
     * @return La chaine encodée
     */
    public static String encode(String s) {
        StringBuilder stb = new StringBuilder().append('"');

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '"' || c == '\\') {
                stb.append('\\');
            }
            stb.append(c);
        }

        stb.append('"');
        return stb.toString();
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day08/input.txt");

        int part1 = 0;
        int part2 = 0;

        for(String line : lines) {
            String encodedLine = encode(line);

            part1 += line.length() - countInMemorySize(line);
            part2 += encodedLine.length() - countInMemorySize(encodedLine);
        }

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
