package org.slicedPotatoes.adventOfCode._2015.day09;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private String id;
    private Map<Node, Integer> roads;

    public Node(String id) {
        this.id = id;
        this.roads = new HashMap<>();
    }

    /**
     * Ajouter un enfant au nœud avec une distance
     *
     * @param n Enfant
     * @param d Distance
     */
    public void addRoad(Node n, int d) {
        this.roads.put(n, d);
    }

    // Utilisé pour debug
    public String getId() { return this.id; }

    /**
     * Récupérer la distance entre le nœud courant et le nœud passé en paramètre
     *
     * @param n Noeud
     * @return Distance entre les deux nœuds
     */
    public int getDistance(Node n) { return this.roads.get(n); }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node n) {
            return n.id.equals(this.id);
        }

        return false;
    }

    @Override
    public int hashCode() { return this.id.hashCode(); }
}
