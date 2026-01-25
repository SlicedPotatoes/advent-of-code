package org.slicedPotatoes.adventOfCode._2015.day07.operation;

/**
 * Classe concrète d'une Opération bitwise NOT
 */
public class NOT extends Operation {
    @Override
    public Integer process() {
        if(super.operand.size() != 1) {
            throw new RuntimeException("L'opération n'est pas complete");
        }

        return ~ super.operand.get(0);
    }
}
