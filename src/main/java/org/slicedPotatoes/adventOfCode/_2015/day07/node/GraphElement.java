package org.slicedPotatoes.adventOfCode._2015.day07.node;

import java.util.Map;

/**
 * Classe abstraite représentant un élément du graphe
 */
public interface GraphElement {
    /**
     * Récupérer la valeur avec memoization.
     *
     * @param memo Memoization
     * @return Valeur
     */
    int getValue(Map<String, Integer> memo);
}
