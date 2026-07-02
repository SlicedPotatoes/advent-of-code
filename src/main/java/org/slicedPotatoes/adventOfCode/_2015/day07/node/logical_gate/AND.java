package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

import java.util.Map;

/**
 * Effectue un ET logique bit à bit entre deux opérandes
 */
public class AND extends LogicalGate {
    public AND(GraphElement[] input) {
        super(input);
    }

    @Override
    public int getValue(Map<String, Integer> memo) {
        int inputA = input[0].getValue(memo);
        int inputB = input[1].getValue(memo);

        return inputA & inputB;
    }
}
