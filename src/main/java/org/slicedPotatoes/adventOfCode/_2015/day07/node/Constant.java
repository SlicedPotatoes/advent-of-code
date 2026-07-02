package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

/**
 * Constante avec une valeur
 */
public class Constant implements GraphElement {
    private final int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int getValue(Map<String, Integer> memo) {
        return this.value;
    }
}