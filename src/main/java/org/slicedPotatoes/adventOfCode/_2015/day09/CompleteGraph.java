package org.slicedPotatoes.adventOfCode._2015.day09;

import java.util.*;

/**
 * Représente un état pour la mémoization
 *
 * @param curr Ville actuelle
 * @param toVisit Ville qui reste à visiter
 */
record State(Node curr, Set<Node> toVisit) {}

public class CompleteGraph {
    private Map<String, Node> nodes;

    public CompleteGraph() {
        this.nodes = new HashMap<>();
    }

    /**
     * Retourne le nœud avec l'id passez en paramètre
     * Si le nœud n'existe pas, il est créé
     *
     * @param id id du nœud
     * @return Le nœud
     */
    private Node getOrCreateNode(String id) {
        if(!this.nodes.containsKey(id)) {
            this.nodes.put(id, new Node(id));
        }

        return this.nodes.get(id);
    }

    /**
     * Ajouter une arête entre deux nœuds
     *
     * @param id1 id du premier nœud
     * @param id2 id du second nœud
     * @param d poid de l'arête
     */
    public void addVertex(String id1, String id2, int d) {
        Node n1 = getOrCreateNode(id1);
        Node n2 = getOrCreateNode(id2);

        n1.addRoad(n2, d);
        n2.addRoad(n1, d);
    }

    /**
     * Fonction helper pour travellingSalesman<br>
     *
     * À partir d'une ville courante, va parcourir chacune des villes possibles récursivement<br>
     * Utilisation de backtracking pour visiter toutes les combinaisons possibles de ville.<br>
     * Utilisation de memoization pour éviter de recalculer les sous problème déjà calculé
     *
     * @param curr Ville actuelle
     * @param toVisit Ville qui reste à visiter
     * @param f Fonction de comparaison pour calculer le résultat
     * @param startValue Valeur initiale du résultat
     * @param memo Memoization
     * @return La valeur pour la ville curr
     */
    private int travellingSalesman(Node curr, Set<Node> toVisit, Comparator<Integer> f, int startValue, Map<State, Integer> memo) {
        State state = new State(curr, Collections.unmodifiableSet(toVisit));

        if(!memo.containsKey(state)) {
            if(toVisit.isEmpty()) {
                return 0;
            }

            int best = startValue;

            for(Node n : toVisit.stream().toList()) {
                toVisit.remove(n);

                int bestLocal = travellingSalesman(n, toVisit, f, startValue, memo) + curr.getDistance(n);
                best = f.compare(best, bestLocal);

                toVisit.add(n);
            }

            memo.put(state, best);
            return best;
        }

        return memo.get(state);
    }

    /**
     * Problème du voyageur de commerce<br>
     *
     * En fonction de la lambda f, permet de récupérer le minimum ou maximum
     *
     * @param f Lambda pour définir le comportement
     * @param startValue Valeur par défault
     */
    public int travellingSalesman(Comparator<Integer> f, int startValue) {
        Map<State, Integer> memo = new HashMap<>();
        Set<Node> toVisit = new HashSet<>(this.nodes.values());

        int best = startValue;

        for(Node n : toVisit.stream().toList()) {
            toVisit.remove(n);

            best = f.compare(best, travellingSalesman(n, toVisit, f, startValue, memo));

            toVisit.add(n);
        }

        return best;
    }
}
