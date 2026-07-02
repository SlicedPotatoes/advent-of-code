package org.slicedPotatoes.adventOfCode._2015.day07;

import org.slicedPotatoes.adventOfCode._2015.day07.node.GraphElement;
import org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate.LogicalGate;
import org.slicedPotatoes.adventOfCode._2015.day07.node.logical_gate.LogicalGateFactory;
import org.slicedPotatoes.adventOfCode.utils.ExecutionTime;
import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    private static void parseLine(String line, Circuit circuit) {
        String[] parsedLine = line.split(" -> ");

        String[] operationElements = parsedLine[0].split(" ");

        if(operationElements.length == 1) {
            circuit.assignInputToWire(operationElements[0], parsedLine[1]);
        }
        else if(operationElements.length == 2) {
            LogicalGate logicalGate = LogicalGateFactory.create(operationElements[0]);

            GraphElement[] n = new GraphElement[] {
                    circuit.getElement(operationElements[1])
            };

            logicalGate.setInput(n);
            circuit.assignLogicalGateInputToWire(logicalGate, parsedLine[1]);
        }
        else {
            LogicalGate logicalGate = LogicalGateFactory.create(operationElements[1]);

            GraphElement[] inputs = new GraphElement[] {
                    circuit.getElement(operationElements[0]),
                    circuit.getElement(operationElements[2])
            };

            logicalGate.setInput(inputs);

            circuit.assignLogicalGateInputToWire(logicalGate, parsedLine[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = ReadFile.getLines("_2015/day07/input.txt");

        Circuit circuit = new Circuit();

        for(String line : lines) {
            parseLine(line, circuit);
        }

        Map<String, Integer> memo = new HashMap<>();

        AtomicInteger part1 = new AtomicInteger();
        ExecutionTime.measure(() -> part1.set(circuit.getElement("a").getValue(memo)));

        circuit.assignInputToWire(String.valueOf(part1), "b");
        memo.clear();

        AtomicInteger part2 = new AtomicInteger();
        ExecutionTime.measure(() -> part2.set(circuit.getElement("a").getValue(memo)));

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
