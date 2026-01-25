package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

/**
 * Classe concrète d'un nœud "fil"
 * <p>Il peut envoyer un signal codé sur 16 bits (2 octets).</p>
 */
public class Wire extends Node {
    private Node parent;
    private String id;

    public Wire(String id) { this.id = id; }

    public void setParent(Node n) { this.parent = n; }

    @Override
    public Integer getValue(Map<String, Integer> memo) {
        if(!memo.containsKey(this.id)) {
            int value = this.parent.getValue(memo) & 0xFFFF;

            memo.put(this.id, value);
        }

        return memo.get(this.id);
    }
}
