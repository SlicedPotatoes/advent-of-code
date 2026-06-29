package org.slicedPotatoes.adventOfCode._2015.day15;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {
    @Test
    void test() {
        // Arrange
        Ingredient butterscotch = new Ingredient("Butterscotch", -1, -2, 6, 3, 8);
        Ingredient cinnamon = new Ingredient("Cinnamon", 2, 3, -2, -1, 3);

        Map<Ingredient, Integer> map = Map.of(butterscotch, 42, cinnamon, 58);
        Cookie cookie = new Cookie(map);

        // Act
        int score = cookie.score();

        // Assert
        assertEquals(61591680, score);
        assertEquals(510, cookie.calories());
    }
}