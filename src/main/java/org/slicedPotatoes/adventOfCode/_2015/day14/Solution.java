package org.slicedPotatoes.adventOfCode._2015.day14;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int SIMULATION_TIME = 2503;

    /**
     * Calcul l'incrémente du score pour un tour de la simulation
     */
    public static void computeScorePart2(Reindeer[] reindeers, int[] scores) {
        Reindeer best = reindeers[0];

        for (int i = 1; i < reindeers.length; i++) {
            if(reindeers[i].getCurrent_distance() > best.getCurrent_distance()){
                best = reindeers[i];
            }
        }

        for (int i = 0; i < reindeers.length; i++) {
            if(reindeers[i].getCurrent_distance() == best.getCurrent_distance()){
                scores[i] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day14/input.txt");

        Reindeer[] reindeers = new Reindeer[content.size()];

        // Parsing
        for(int i = 0; i < reindeers.length; i++) {
            String[] splitedLine = content.get(i).split(" ");

            String name = splitedLine[0];
            int speed = Integer.parseInt(splitedLine[3]);
            int max_speed_time = Integer.parseInt(splitedLine[6]);
            int resting_time = Integer.parseInt(splitedLine[13]);

            reindeers[i] = new Reindeer(name, speed, max_speed_time, resting_time);
        }

        // Simulate
        int[] scoresP2 = new int[reindeers.length];
        for (int i = 0; i < SIMULATION_TIME; i++) {
            for (Reindeer reindeer : reindeers) {
                reindeer.turn();
            }

            computeScorePart2(reindeers, scoresP2);
        }

        // Result
        int part1 = Arrays.stream(reindeers).mapToInt(Reindeer::getCurrent_distance).max().orElse(0);
        int part2 = Arrays.stream(scoresP2).max().orElse(0);

        System.out.println("Part1: " + part1);
        System.out.println("Part1: " + part2);
    }
}
