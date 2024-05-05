package com.hyungjunn.modern_java_in_action._05_store2;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TransactionCalculator {
    public static List<Transaction> organize(List<Transaction> transactions) {
        return transactions.stream()
                .filter(it -> it.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(toList());
    }
}
