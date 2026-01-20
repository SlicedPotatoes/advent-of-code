package org.slicedPotatoes.adventOfCode._2015.day03;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day03/input.txt");
        Set<Point> set = new HashSet<>();

        int[] x = new int[]{0, 0};
        int[] y = new int[]{0, 0};

        set.add(new Point(0, 0));

        for(int i = 0; i < content.length(); i++) {
            int dx = 0;
            int dy = 0;

            switch (content.charAt(i)) {
                case '>':
                    dx = 1;
                    break;
                case '<':
                    dx = -1;
                    break;
                case 'v':
                    dy = 1;
                    break;
                case '^':
                    dy = -1;
                    break;
            }

            x[i%2] += dx;
            y[i%2] += dy;

            set.add(new Point(x[i%2], y[i%2]));
        }

        System.out.println("Résultat: " + set.size());
    }
}
