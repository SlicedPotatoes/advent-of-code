package org.slicedPotatoes.adventOfCode._2015.day16;

import java.util.function.BiPredicate;

public record Condition(
   int value,
   Type type
) {
    public enum Type {
        EQUALS(Integer::equals),
        GREATER_THAN((a, b) -> a > b),
        LESS_THAN((a, b) -> a < b);

        private final BiPredicate<Integer, Integer> eval;

        Type(BiPredicate<Integer, Integer> eval) {
            this.eval = eval;
        }
    }

    public boolean evaluatePart1(int value) {
        return this.value == value;
    }

    public boolean evaluatePart2(int value) {
        return type.eval.test(value, this.value);
    }
}
