package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import java.util.Map;

/**
 * Effectue un NOT logique bit à bit sur un opérande
 */
public class NOT extends LogicalGate {
    @Override
    public int getValue(Map<String, Integer> memo) {
        return ~ input[0].getValue(memo);
    }
}
