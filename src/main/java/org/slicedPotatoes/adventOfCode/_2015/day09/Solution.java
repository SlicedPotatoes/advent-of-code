package org.slicedPotatoes.adventOfCode._2015.day09;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day09/input.txt");

        CompleteGraph graph = new CompleteGraph();

        // Construire le graph
        for(String line : lines) {
            String[] splitedLine = line.split(" = ");
            String[] citys = splitedLine[0].split(" to ");

            graph.addVertex(citys[0], citys[1], Integer.parseInt(splitedLine[1]));
        }

        int part1 = graph.travellingSalesman(Math::min, Integer.MAX_VALUE);
        int part2 = graph.travellingSalesman(Math::max, 0);

        System.out.println("Part1: " + part1);
        System.out.println("part2: " + part2);
    }
}
