package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import java.util.Map;

/**
 * Effectue un décalage de bits vers la gauche
 * <br>
 * L'opérande 1 est décalé de n bit, n est définie par l'opérande 2
 */
public class LSHIFT extends LogicalGate {
    @Override
    public int getValue(Map<String, Integer> memo) {
        int inputA = input[0].getValue(memo);
        int inputB = input[1].getValue(memo);

        return inputA << inputB;
    }
}
