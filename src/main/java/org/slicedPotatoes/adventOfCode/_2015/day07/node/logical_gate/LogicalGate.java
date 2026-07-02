package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

/**
 * Classe abstraite de ce qu'est une porte logique
 */
public abstract class LogicalGate implements GraphElement {
    protected final GraphElement[] input;

    protected LogicalGate(GraphElement ...input) {
        this.input = input;
    }
}
