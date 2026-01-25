package org.slicedPotatoes.adventOfCode._2015.day07.operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite représentant une Operation
 */
public abstract class Operation {
    protected List<Integer> operand;

    public Operation() { this.operand = new ArrayList<>(); }

    /**
     * Vide la liste d'opérande
     */
    public void clear() { this.operand.clear(); }

    /**
     * Ajoute un opérande à l'opération
     *
     * @param operand opérande à ajouter
     */
    public void addOperad(Integer operand) { this.operand.add(operand); }

    /**
     * Effectuer le calcul de l'opération
     *
     * @return Le résultat
     */
    public abstract Integer process();
}
