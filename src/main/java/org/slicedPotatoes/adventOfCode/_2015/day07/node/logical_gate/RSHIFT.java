package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

import java.util.Map;

/**
 * Effectue un décalage de bits vers la droite
 * <br>
 * L'opérande 1 est décalé de n bit, n est définie par l'opérande 2
 */
public class RSHIFT extends LogicalGate {
    public RSHIFT(GraphElement[] input) {
        super(input);
    }

    @Override
    public int getValue(Map<String, Integer> memo) {
        int inputA = input[0].getValue(memo);
        int inputB = input[1].getValue(memo);

        return inputA >> inputB;
    }
}
