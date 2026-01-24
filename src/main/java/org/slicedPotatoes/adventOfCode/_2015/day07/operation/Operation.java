package org.slicedPotatoes.adventOfCode._2015.day07.operation;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation {
    protected List<Integer> operand;

    public Operation() { this.operand = new ArrayList<>(); }

    public void clear() { this.operand.clear(); }
    public void addOperad(Integer operand) { this.operand.add(operand); }

    public abstract Integer process();
}
