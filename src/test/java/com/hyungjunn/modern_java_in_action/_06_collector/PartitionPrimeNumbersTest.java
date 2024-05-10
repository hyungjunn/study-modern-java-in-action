package com.hyungjunn.modern_java_in_action._06_collector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class PartitionPrimeNumbersTest {
    @Test
    void testPartitionPrimes() {
        Map<Boolean, List<Integer>> partitionPrimes =  PartitionPrimeNumbers.partitionPrimes(100);
        System.out.println(partitionPrimes);
    }

    @Test
    void testPartitionPrimesWithCustomCollector() {
        Map<Boolean, List<Integer>> partitionPrimes = PartitionPrimeNumbers.partitionPrimesWithCustomCollector(100);
        System.out.println(partitionPrimes);

        // 소수 리스트를 가져온다
        List<Integer> primes = partitionPrimes.get(true);
        // 비소수 리스트를 가져온다
        List<Integer> nonPrimes = partitionPrimes.get(false);
        // 소수가 아닌 수의 리스트가 올바른지 검증한다
        Assertions.assertThat(nonPrimes)
                .allMatch(i -> primes.stream().anyMatch(prime -> i % prime == 0));
    }

    @Test
    void collectorHarness() {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            PartitionPrimeNumbers.partitionPrimes(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");
    }

    @Test
    void collectorHarnessWithCustomCollector() {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            PartitionPrimeNumbers.partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");
    }
}
