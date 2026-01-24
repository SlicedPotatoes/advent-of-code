package org.slicedPotatoes.adventOfCode._2015.day07.operation;

public class LSHIFT extends Operation {
    @Override
    public Integer process() {
        if(super.operand.size() != 2) {
            throw new RuntimeException("L'opération n'est pas complete");
        }

        return super.operand.get(0) << super.operand.get(1);
    }
}
