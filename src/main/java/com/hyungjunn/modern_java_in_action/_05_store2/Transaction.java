package com.hyungjunn.modern_java_in_action._05_store2;

public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getValue() {
        return value;
    }
}
