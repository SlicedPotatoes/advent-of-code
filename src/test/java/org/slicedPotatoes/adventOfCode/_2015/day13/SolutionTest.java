package org.slicedPotatoes.adventOfCode._2015.day13;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    int[][] getHappiness() {
        return new int[][]{
                new int[]{0, 54, -79, -2},
                new int[]{83, 0, -7, -63},
                new int[]{-62, 60, 0, 55},
                new int[]{46, -7, 41, 0}
        };
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "6, 3",
            "12, 4",
            "20, 5",
            "30, 6",
            "42, 7",
            "56, 8"
    })
    void testFindNbPeople(int nbLine, int expected) {
        assertEquals(expected, Solution.findNbPeople(nbLine));
    }

    @Test
    void testMaximiseArrangementScore() {
        // Arrange
        int[][] happiness = getHappiness();
        int nbPeoples = happiness.length;

        boolean[] see = new boolean[nbPeoples];
        int[] current = new int[nbPeoples];

        // Act
        int result = Solution.part1(nbPeoples,happiness);

        // Assert
        assertEquals(330, result);
    }
}