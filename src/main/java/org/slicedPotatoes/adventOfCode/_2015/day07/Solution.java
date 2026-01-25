package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.node.LogicGate;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Node;
import org.slicedPotatoes.adventOfCode._2015.day07.operation.Operation;
import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Circuit circuit;

    /**
     * Parse une ligne, créer le nœud et les liaisons correspondants dans le circuit
     *
     * @param line
     */
    private static void parseLine(String line) {
        // parsedLine[0] = L'opération à effectuer (Ex : x AND y)
        // parsedLine[1] = Variable où stocker le résultat
        String[] parsedLine = line.split(" -> ");

        String[] operationElements = parsedLine[0].split(" ");

        if(operationElements.length == 1) {
            circuit.assignNodeToNode(operationElements[0], parsedLine[1]);
        }
        else if(operationElements.length == 2) {
            Operation op = OperationFactory.create(operationElements[0]);
            Node n1 = circuit.getNode(operationElements[1]);

            circuit.addLogicGateToInputWire(
                new LogicGate(op, n1),
                parsedLine[1]
            );
        }
        else {
            Operation op = OperationFactory.create(operationElements[1]);
            Node n1 = circuit.getNode(operationElements[0]);
            Node n2 = circuit.getNode(operationElements[2]);

            circuit.addLogicGateToInputWire(
                new LogicGate(op, n1, n2),
                parsedLine[1]
            );
        }
    }

    public static void main(String[] args) throws IOException {
        circuit = new Circuit();

        List<String> lines = ReadFile.getLines("_2015/day07/input.txt");

        for(String line : lines) {
            parseLine(line);
        }

        Map<String, Integer> memo = new HashMap<>();

        int part1 = circuit.getNode("a").getValue(memo);
        circuit.assignNodeToNode(String.valueOf(part1), "b");
        memo.clear();
        int part2 = circuit.getNode("a").getValue(memo);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
