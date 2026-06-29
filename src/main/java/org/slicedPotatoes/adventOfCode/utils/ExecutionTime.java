package org.slicedPotatoes.adventOfCode.utils;

public class ExecutionTime {

    public static void measure(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " ns");
    }

}
