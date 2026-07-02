package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

import java.util.Map;

/**
 * Effectue un OR logique bit à bit entre deux opérandes
 */
public class OR  extends LogicalGate {
    public OR(GraphElement[] input) {
        super(input);
    }

    @Override
    public int getValue(Map<String, Integer> memo) {
        int inputA = input[0].getValue(memo);
        int inputB = input[1].getValue(memo);

        return inputA | inputB;
    }
}
