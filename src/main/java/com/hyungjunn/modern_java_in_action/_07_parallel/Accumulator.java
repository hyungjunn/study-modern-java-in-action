package com.hyungjunn.modern_java_in_action._07_parallel;

public class Accumulator {
    private long total = 0;

    public void add(long value) {
        total += value;
    }

    public long getTotal() {
        return this.total;
    }
}
