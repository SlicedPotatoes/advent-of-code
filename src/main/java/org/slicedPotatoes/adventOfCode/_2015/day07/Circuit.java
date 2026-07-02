package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.node.Constant;
import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Wire;
import org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate.LogicalGate;

import java.util.HashMap;
import java.util.Map;

public class Circuit {
    private Map<String, Wire> wires = new HashMap<>();

    /**
     * Renvoie un {@link Wire} à partir de son id <br>
     * Si aucun {@link Wire} n'existe avec cet id, il est créé
     *
     * @param id ID du {@link Wire}
     * @return {@link Wire} avec l'id correspondant
     */
    private Wire getWire(String id) {
        if (!wires.containsKey(id)) {
            wires.put(id, new Wire(id));
        }

        return wires.get(id);
    }

    /**
     * Récupérer un {@link GraphElement} à partir d'une chaine de caractère <br>
     * <p>
     * Si la chaine est un entier, renvoie une {@link Constant} <br>
     * Sinon renvoie un {@link Wire}
     *
     * @param id Chaine de caractère
     * @return Le {@link GraphElement} correspondant
     */
    public GraphElement getElement(String id) {
        try {
            return new Constant(Integer.parseInt(id));
        } catch (Exception _) {
            return getWire(id);
        }
    }

    /**
     * Assigner une entrée à un {@link Wire}
     *
     * @param value Valeur à assigner
     * @param idTo  id du {@link Wire}
     */
    public void assignInputToWire(String value, String idTo) {
        GraphElement from = getElement(value);
        Wire to = getWire(idTo);

        to.setInput(from);
    }

    /**
     * Assigner une porte logique en entrée d'un {@link Wire}
     *
     * @param lg   Porte logique
     * @param idTo id du {@link Wire}
     */
    public void assignLogicalGateInputToWire(LogicalGate lg, String idTo) {
        getWire(idTo).setInput(lg);
    }
}
