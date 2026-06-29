package org.slicedPotatoes.adventOfCode._2015.day15;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Ingredient[] ingredients = new Ingredient[] {
            new Ingredient("Butterscotch", -1, -2, 6, 3, 8),
            new Ingredient("Cinnamon", 2, 3, -2, -1, 3)
    };

    @Test
    void testPart1() {
        // Act
        int result = Solution.bestCookie(ingredients, new HashMap<>(), 0, 0, true);

        // Assert
        assertEquals(62842880, result);
    }

    @Test
    void testPart2() {
        // Act
        int result = Solution.bestCookie(ingredients, new HashMap<>(), 0, 0, false);

        // Assert
        assertEquals(57600000,  result);
    }
}