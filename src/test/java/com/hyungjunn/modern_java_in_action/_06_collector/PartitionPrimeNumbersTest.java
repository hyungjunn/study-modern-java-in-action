package com.hyungjunn.modern_java_in_action._06_collector;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class PartitionPrimeNumbersTest {
    @Test
    void testPartitionPrimes() {
        Map<Boolean, List<Integer>> partitionPrimes =  PartitionPrimeNumbers.partitionPrimes(100);
        System.out.println(partitionPrimes);
    }
}
