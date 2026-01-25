package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.operation.*;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Classe permettant de récupérer une instance d'Operation à partir d'une chaine de caractère
 */
public class OperationFactory {
    private static final Map<String, Supplier<Operation>> OPERATIONS = Map.ofEntries(
            Map.entry("OR", OR::new),
            Map.entry("AND", AND::new),
            Map.entry("LSHIFT", LSHIFT::new),
            Map.entry("RSHIFT", RSHIFT::new),
            Map.entry("NOT", NOT::new)
    );

    public static Operation create(String operation) {
        Supplier<Operation> o = OPERATIONS.get(operation);

        if(o == null) { throw new IllegalArgumentException("Opération inconnue: " + operation); }

        return o.get();
    }
}
