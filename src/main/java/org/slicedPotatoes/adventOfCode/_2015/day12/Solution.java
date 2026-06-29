package org.slicedPotatoes.adventOfCode._2015.day12;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.JsonNodeType;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {
    /**
     * Parcourir le JSON et faire la somme de tous les nombres présents.
     */
    public static int part1(JsonNode node) {
        if(node.getNodeType() == JsonNodeType.NUMBER) {
            return node.asInt();
        }

        if(node.isArray() || node.isObject()) {
            AtomicInteger count = new AtomicInteger();

            node.forEach(n -> count.addAndGet(part1(n)));

            return count.get();
        }

        return 0;
    }

    /**
     * Parcourir le JSON et faire la somme de tous les nombres présents.
     * <br>
     * Ignorer les objets qui contiennent la valeur "red" pour une clé
     */
    public static int part2(JsonNode node) {
        if(node.getNodeType() == JsonNodeType.NUMBER) {
            return node.asInt();
        }

        if(node.isArray()) {
            AtomicInteger count = new AtomicInteger();
            node.forEach(n -> count.addAndGet(part2(n)));
            return count.get();
        }

        if(node.isObject()) {
            AtomicInteger count = new AtomicInteger();
            AtomicReference<Boolean> flag = new AtomicReference<>(false);

            node.forEach(n -> {
                if(n.isString() && n.asString().equals("red")) {
                    flag.set(true);
                }

                count.addAndGet(part2(n));
            });

            if(!flag.get()) {
                return count.get();
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day12/input.txt");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(content);

        System.out.println("Part 1: " + part1(root));
        System.out.println("Part 2: " + part2(root));
    }
}
