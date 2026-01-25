package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

/**
 * Classe abstraite nœud
 */
public abstract class Node {
    /**
     * Récupérer la valeur d'un nœud avec memoization.
     *
     * @param memo Memoization
     * @return Valeur du nœud
     */
    public abstract Integer getValue(Map<String, Integer> memo);
}
