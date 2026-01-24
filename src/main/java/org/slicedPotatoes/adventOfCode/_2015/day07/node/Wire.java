package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

public class Wire extends Node {
    private Node parent;
    private String id;

    public Wire(String id) { this.id = id; }

    public void setParent(Node n) { this.parent = n; }

    @Override
    public Integer getValue(Map<String, Integer> memo) {
        if(!memo.containsKey(this.id)) {
            memo.put(this.id, this.parent.getValue(memo));
        }

        return memo.get(this.id);
    }
}
