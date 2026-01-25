package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.node.LogicGate;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Node;
import org.slicedPotatoes.adventOfCode._2015.day07.node.ValueNode;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Wire;

import java.util.HashMap;
import java.util.Map;

public class Circuit {
    // Map pour associer un id et un nœud cable
    private Map<String, Wire> wires;

    public Circuit() {
        this.wires = new HashMap<>();
    }

    /**
     * Renvoie un Wire à partir de son id<br>
     * Si aucun Wire n'existe avec cet id, il est créé
     *
     * @param id ID d'un Wire
     * @return Wire avec l'id correspondant
     */
    private Wire getOrCreateWire(String id) {
        if(!this.wires.containsKey(id)) {
            this.wires.put(id, new Wire(id));
        }

        return this.wires.get(id);
    }

    /**
     * Récupère un nœud à partir d'une chaine de caractère<br>
     *
     * <p>Si la chaine est un entier, renvois un nœud de type ValueNode<br>
     * Sinon renvoie un nœud de type Wire</p>
     *
     * @param s Chaine de caractère
     * @return Le nœud correspondant
     */
    public Node getNode(String s) {
        try {
            return new ValueNode(Integer.parseInt(s));
        }
        catch (Exception e) {
            return this.getOrCreateWire(s);
        }
    }

    /**
     * Assigner une valeur à un nœud, la valeur peut être un autre nœud
     *
     * @param from Valeur à assigner
     * @param idTo Nœud de destination
     */
    public void assignNodeToNode(String from, String idTo) {
        Node fromN = this.getNode(from);
        Wire toN = this.getOrCreateWire(idTo);

        toN.setParent(fromN);
    }

    /**
     * Ajouter une porte logique en entrée d'un fils
     *
     * @param lg Nœud porte logique
     * @param to Nœud fil
     */
    public void addLogicGateToInputWire(LogicGate lg, String to) {
        this.getOrCreateWire(to).setParent(lg);
    }
}
