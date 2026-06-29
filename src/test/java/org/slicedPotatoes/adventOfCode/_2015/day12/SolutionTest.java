package org.slicedPotatoes.adventOfCode._2015.day12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private ObjectMapper mapper = new ObjectMapper();

    private static Stream<Arguments> part1() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("{\"a\":2,\"b\":4}", 6),
                Arguments.of("[[[3]]]", 3),
                Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
                Arguments.of("{\"a\":[-1,1]}", 0),
                Arguments.of("[-1,{\"a\":1}]", 0),
                Arguments.of("[]", 0),
                Arguments.of("{}", 0)
        );
    }

    private static Stream<Arguments> part2() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
                Arguments.of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
                Arguments.of("[1,\"red\",5]", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("part1")
    void testPart1(String input, int expected) {
        JsonNode node = mapper.readTree(input);
        assertEquals(expected, Solution.part1(node));
    }

    @ParameterizedTest
    @MethodSource("part2")
    void testPart2(String input, int expected) {
        JsonNode node = mapper.readTree(input);
        assertEquals(expected, Solution.part2(node));
    }
}