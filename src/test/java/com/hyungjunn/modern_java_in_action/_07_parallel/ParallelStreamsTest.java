package com.hyungjunn.modern_java_in_action._07_parallel;

import org.junit.jupiter.api.Test;

import static com.hyungjunn.modern_java_in_action._07_parallel.ParallelStreamHarness.measurePerf;
import static org.assertj.core.api.Assertions.assertThat;

public class ParallelStreamsTest {
    @Test
    void testSequentialSum() {
        long sum = ParallelStreams.sequentialSum(10_000_000L);

        assertThat(sum).isEqualTo(50_000_005_000_000L);
    }

    @Test
    void testIterativeSum() {
        long sum = ParallelStreams.iterativeSum(10_000_000L);

        assertThat(sum).isEqualTo(50_000_005_000_000L);
    }

    @Test
    void testParallelSum() {
        long sum = ParallelStreams.parallelSum(10_000_000L);

        assertThat(sum).isEqualTo(50_000_005_000_000L);
    }

    @Test
    void testSideEffectParallelSum() {
        //System.out.println("SideEffect sum done in: " + measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        //System.out.println("SideEffect parallel sum done in: " + measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
        System.out.println("ForkJoin sum done in: " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_001L) + " msecs" );
    }
}
