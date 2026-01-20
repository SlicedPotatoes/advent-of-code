package org.slicedPotatoes.adventOfCode._2015.day01;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String content = ReadFile.getFullFile("_2015/day01/input.txt");

        int curr = 0;

        for(int i = 0; i < content.length(); i++) {
            if(content.charAt(i) == '(') {
                curr++;
            }
            else {
                curr--;
            }

            if(curr == -1) {
                System.out.println("Résultat: " + (i+1));
                break;
            }
        }
    }
}
