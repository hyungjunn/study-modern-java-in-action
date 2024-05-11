package com.hyungjunn.modern_java_in_action._07_parallel;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@Measurement(iterations = 2)
@Warmup(iterations = 3)
public class ParallelStreamBenchMark {

    private final long N = 10_000_000L;

//    @Benchmark
//    public long sequentialSum() {
//        return Stream.iterate(1L, i -> i + 1)
//                .limit(N)
//                .reduce( 0L, Long::sum );
//    }

//    @Benchmark
//    public long iterativeSum() {
//        long sum = 0;
//        for (long i = 1L; i <= N; i++) {
//            sum += 1;
//        }
//        return sum;
//    }

//    @Benchmark
//    public long parallelSum() {
//        return Stream.iterate(1L, i -> i + 1)
//                .limit(N)
//                .parallel()
//                .reduce(0L, Long::sum);
//    }

//    @Benchmark
//    public long rangedSum() {
//        return LongStream.rangeClosed(1, N)
//                .reduce(0L, Long::sum);
//    }

    @Benchmark
    public long rangedSum() {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}
