package org.slicedPotatoes.adventOfCode._2015.day16;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day16/input.txt");

        // Règles
        Map<String, Condition> map = Map.of(
                "children", new Condition(3, Condition.Type.EQUALS),
                "cats", new Condition(7, Condition.Type.GREATER_THAN),
                "samoyeds", new Condition(2, Condition.Type.EQUALS),
                "pomeranians", new Condition(3, Condition.Type.LESS_THAN),
                "akitas", new Condition(0, Condition.Type.EQUALS),
                "vizslas", new Condition(0, Condition.Type.EQUALS),
                "goldfish", new Condition(5, Condition.Type.LESS_THAN),
                "trees", new Condition(3, Condition.Type.GREATER_THAN),
                "cars", new Condition(2, Condition.Type.EQUALS),
                "perfumes", new Condition(1, Condition.Type.EQUALS)
        );

        for (int i = 1; i <= content.size(); i++) {
            // Parsing
            String[] splitedLine = content.get(i - 1).split(": ", 2);
            String[] datas = splitedLine[1].split(", ");

            boolean validP1 = true;
            boolean validP2 = true;

            for (String s : datas) {
                // Parsing
                String[] data = s.split(": ");
                String key = data[0];
                int value = Integer.parseInt(data[1]);

                // Evaluation
                Condition condition = map.get(key);
                if (!condition.evaluatePart1(value)) {
                    validP1 = false;
                }
                if (!condition.evaluatePart2(value)) {
                    validP2 = false;
                }
            }

            // Résultat
            if(validP1) {
                System.out.println("Part1: " + i);
            }
            if(validP2) {
                System.out.println("Part2: " + i);
            }
        }
    }
}
