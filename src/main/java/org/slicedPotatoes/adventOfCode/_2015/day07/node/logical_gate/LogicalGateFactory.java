package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

/**
 * Factory permettant de créer des instances de porte logique.
 */
public class LogicalGateFactory {
    /**
     * Renvoie une instance d'une porte logique à partir d'un string
     */
    public static LogicalGate create(String operation, GraphElement ...input) {
        return switch (operation) {
            case "AND" -> new AND(input);
            case "LSHIFT" -> new LSHIFT(input);
            case "NOT" -> new NOT(input);
            case "OR" -> new OR(input);
            case "RSHIFT" -> new RSHIFT(input);

            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
