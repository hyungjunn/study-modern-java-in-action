package com.hyungjunn.modern_java_in_action._07_parallel;

import java.util.function.Function;

public class ParallelStreamHarness {
    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
