package org.slicedPotatoes.adventOfCode._2015.day02;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.Arrays;

public class Part2 {
    public static void main(String[] args) throws IOException {
        int res = ReadFile.getStream("_2015/day02/input.txt")
                .map(s -> Arrays.stream(s.split("x"))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .toArray()
                )
                .mapToInt(e -> e[0]*e[1]*e[2] + 2*e[0]+2*e[1])
                .sum();


        System.out.println("Résultat: " + res);
    }
}
