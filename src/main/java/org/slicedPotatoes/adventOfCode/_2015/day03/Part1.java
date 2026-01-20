package org.slicedPotatoes.adventOfCode._2015.day03;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day03/input.txt");
        Set<Point> set = new HashSet<>();

        int x = 0, y = 0;
        set.add(new Point(0, 0));

        for(int i = 0; i < content.length(); i++) {
            switch (content.charAt(i)) {
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
                case 'v':
                    y++;
                    break;
                case '^':
                    y--;
                    break;
            }

            set.add(new Point(x, y));
        }

        System.out.println("Résultat: " + set.size());
    }
}
