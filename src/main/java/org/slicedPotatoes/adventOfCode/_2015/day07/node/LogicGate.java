package org.slicedPotatoes.adventOfCode._2015.day07.node;

import org.slicedPotatoes.adventOfCode._2015.day07.operation.Operation;

import java.util.Map;

/**
 * Classe concrète d'un nœud porte logique
 */
public class LogicGate extends Node {
    private final Node[] parents;
    private final Operation op;

    public LogicGate(Operation op, Node... parents) {
        this.op = op;
        this.parents = parents;
    }

    @Override
    public Integer getValue(Map<String, Integer> memo) {
        this.op.clear();
        for(Node n : this.parents) {
            this.op.addOperad(n.getValue(memo));
        }

        return this.op.process();
    }
}
