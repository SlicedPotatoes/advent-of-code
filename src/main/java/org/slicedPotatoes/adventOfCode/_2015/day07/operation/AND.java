package org.slicedPotatoes.adventOfCode._2015.day07.operation;

/**
 * Classe concrète d'une Opération bitwise AND
 */
public class AND extends Operation {
    @Override
    public Integer process() {
        if(super.operand.size() != 2) {
            throw new RuntimeException("L'opération n'est pas complete");
        }

        return super.operand.get(0) & super.operand.get(1);
    }
}
