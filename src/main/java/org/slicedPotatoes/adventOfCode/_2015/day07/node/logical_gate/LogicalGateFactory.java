package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory permettant de créer des instances de porte logique.
 */
public class LogicalGateFactory {
    private static final Map<String, Supplier<LogicalGate>> LOGICAL_GATES = Map.ofEntries(
            Map.entry("AND", AND::new),
            Map.entry("LSHIFT", LSHIFT::new),
            Map.entry("NOT", NOT::new),
            Map.entry("OR", OR::new),
            Map.entry("RSHIFT", RSHIFT::new)
    );

    /**
     * Renvoie une instance d'une porte logique à partir d'un string
     */
    public static LogicalGate create(String operation) {
        Supplier<LogicalGate> supplier = LOGICAL_GATES.get(operation);

        if (supplier == null) {
            throw new IllegalArgumentException("Opération inconnue: " + operation);
        }

        return supplier.get();
    }
}
