package org.slicedPotatoes.adventOfCode._2015.day02;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {
    public static void main(String[] args) throws IOException {
        Stream<String> content = ReadFile.getStream("_2015/day02/input.txt");

        int res = content
                .map(s ->
                        Arrays.stream(s.split("x"))
                        .mapToInt(Integer::parseInt)
                        .toArray()
                )
                .mapToInt((e) -> {
                    int s1 = e[0]*e[1];
                    int s2 = e[0]*e[2];
                    int s3 = e[1]*e[2];

                    return 2*s1 + 2*s2 + 2*s3 + Math.min(s1, Math.min(s2, s3));
                })
                .sum();

        System.out.println("Résultat: " + res);
    }
}
