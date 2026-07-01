package org.slicedPotatoes.adventOfCode._2015.day17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test() {
        // Arrange
        int[] containers = new int[] {5, 5, 10, 15, 20};
        int needToStore = 25;

        // Act
        Result result = Solution.process(containers, needToStore);

        // Assert
        assertEquals(4, result.part1);
        assertEquals(3, result.part2);
        assertEquals(2, result.minNbContainer);
    }
}