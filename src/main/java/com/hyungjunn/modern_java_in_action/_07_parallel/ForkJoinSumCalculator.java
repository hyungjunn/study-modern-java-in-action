package com.hyungjunn.modern_java_in_action._07_parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    private static final long THRESHOLD = 10_000_000L;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        // 길이가 THRESHOLD 보다 같거나 작으면 순차적으로 계산 진행
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        // 배열의 첫번째 절반이 더하도록 서브태스크를 생성한다
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        // ForkJoinPool 의 다른 스레드로 새로 생성한 테스크를 비동기로 실행한다(비동기 => 기다리지 않음 = 메서드를 호출만하고 그 결과를 기다리지 않음)
        // 왜냐면 동기로 얘를 먼저 실행하게 되면, rightTask 는 얘가 끝날때까지 계속 기다려야 하기 때문이다
        leftTask.fork();

        // 배열의 나머지 절반을 더하도록 서브태스크를 생성한다
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        // 두번째 서브테스크를 동기로 실행한다. 이때 추가로 분할이 일어날 수 있다(동기 => 기다림)
        Long rightResult = rightTask.compute();
        // join(): computed result
        // 첫 번째 서브태스크의 결과을 읽거나 아직 결과가 없으면 기다린다.
        Long leftResult = leftTask.join();
        // 두 서브태스크의 결과를 조합해 결과로 반환한다
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += i;
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n)
                .toArray();

        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
