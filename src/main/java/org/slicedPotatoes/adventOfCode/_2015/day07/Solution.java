package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.node.LogicGate;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Node;
import org.slicedPotatoes.adventOfCode._2015.day07.node.ValueNode;
import org.slicedPotatoes.adventOfCode._2015.day07.node.Wire;
import org.slicedPotatoes.adventOfCode._2015.day07.operation.Operation;
import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Map<String, Wire> wires = new HashMap<>();

    private static int getInteger(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return -1;
            }

            res *= 10;
            res += s.charAt(i) - '0';
        }

        return res;
    }

    private static Wire getOrCreateWire(String id) {
        if(!wires.containsKey(id)) {
            wires.put(id, new Wire(id));
        }

        return wires.get(id);
    }

    private static Node getNode(String s) {
        int value = getInteger(s);

        if(value == -1) {
            return getOrCreateWire(s);
        }

        return new ValueNode(value);
    }

    private static void parseLine(String line) {
        // parsedLine[0] = L'opération à effectuer (Ex : x AND y)
        // parsedLine[1] = Variable où stocker le résultat
        String[] parsedLine = line.split(" -> ");

        String[] operationElements = parsedLine[0].split(" ");

        Node n;

        if(operationElements.length == 1) {
            n = getNode(operationElements[0]);
        }
        else if(operationElements.length == 2) {
            Operation op = OperationFactory.create(operationElements[0]);
            Node n1 = getNode(operationElements[1]);

            n = new LogicGate(op, n1);
        }
        else {
            Operation op = OperationFactory.create(operationElements[1]);
            Node n1 = getNode(operationElements[0]);
            Node n2 = getNode(operationElements[2]);

            n = new LogicGate(op, n1, n2);
        }

        getOrCreateWire(parsedLine[1]).setParent(n);
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day07/input.txt");

        for(String line : lines) {
            parseLine(line);
        }

        Map<String, Integer> memo = new HashMap<>();

        int part1 = wires.get("a").getValue(memo);
        wires.get("b").setParent(new ValueNode(part1));
        memo.clear();
        int part2 = wires.get("a").getValue(memo);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
