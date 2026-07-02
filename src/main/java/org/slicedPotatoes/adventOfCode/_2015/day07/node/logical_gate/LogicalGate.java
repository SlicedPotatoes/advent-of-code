package org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;

/**
 * Classe abstraite de ce qu'est une porte logique
 */
public abstract class LogicalGate implements GraphElement {
    protected GraphElement[] input;

    /**
     * Définir les opérandes d'entrée
     */
    public void setInput(GraphElement[] input) {
        this.input = input;
    }
}
