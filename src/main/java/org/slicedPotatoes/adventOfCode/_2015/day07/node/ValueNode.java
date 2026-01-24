package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

public class ValueNode extends Node {
    private final int value;

    public ValueNode(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue(Map<String, Integer> memo) {
        return this.value;
    }
}
