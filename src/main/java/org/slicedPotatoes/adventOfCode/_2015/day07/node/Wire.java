package org.slicedPotatoes.adventOfCode._2015.day07.node;


import java.util.Map;

public class Wire implements GraphElement {
    private final String id;
    private GraphElement input;

    public Wire(String id) {
        this.id = id;
    }

    public void setInput(GraphElement input) {
        this.input = input;
    }

    @Override
    public int getValue(Map<String, Integer> memo) {
        if(!memo.containsKey(this.id)) {
            int value = this.input.getValue(memo) & 0xFFFF; // 16bits
            memo.put(this.id, value);
        }

        return memo.get(this.id);
    }
}
