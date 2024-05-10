package com.hyungjunn.modern_java_in_action._06_collector;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitionPrimeNumbers {

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(partitioningBy(i -> isPrime(i)));
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new PrimeNumbersCollector());
    }

    // 컬렉터 수집 과정에서 부분 결과에 접근할 수 있도록
    // 중간 결과 리스트를 파라미터에 추가 => List<Integer> primes
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    // 자바 9부터는 프레디케이트를 만족하는 가장 긴 리스트로 반환하는 takeWhile
    // 그렇다면 자바 8 이었을 때는 이 기능을 구현하려면 어떻게 해야할까?
    // takeWhile 의 정의
    // Returns, if this stream is ordered, a stream consisting of the longest prefix
    // of elements taken from this stream
    // that match the given predicate
    private static <A> List<A> myTakeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
    // 하지만 이 연산은 lazy 하지 못하다. (eager 하다)

    private static boolean myIsPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return myTakeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }
}

