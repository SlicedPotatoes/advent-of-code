package org.slicedPotatoes.adventOfCode._2015.day14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReindeerTest {

    @ParameterizedTest
    @CsvSource({
            "14, 10, 127, 1120",
            "16, 11, 162, 1056"
    })
    void testTurn(int speed, int max_speed_time, int resting_time, int expected) {
        // Arrange
        Reindeer r = new Reindeer("A", speed, max_speed_time, resting_time);

        // Act
        for (int i = 0; i < 1000; i++) {
            r.turn();
        }

        // Assert
        assertEquals(expected, r.getCurrent_distance());
    }
}