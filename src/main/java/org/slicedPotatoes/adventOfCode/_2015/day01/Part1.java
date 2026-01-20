package org.slicedPotatoes.adventOfCode._2015.day01;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day01/input.txt");

        int curr = content.chars().map(i -> i == "(".codePointAt(0) ? 1 : -1).sum();

        System.out.println("Résultat: " + curr);
    }
}
