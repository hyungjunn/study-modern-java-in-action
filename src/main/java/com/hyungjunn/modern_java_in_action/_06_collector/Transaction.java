package com.hyungjunn.modern_java_in_action._06_collector;

public class Transaction {
    private final Currency currency;
    private final double value;

    public Transaction(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return this.currency;
    }
}
