package com.hyungjunn.modern_java_in_action._05_store2;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TransactionCalculator {
    public static List<Transaction> organize(List<Transaction> transactions) {
        return transactions.stream()
                .filter(it -> it.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getYear))
                .collect(toList());
    }

    public static List<String> arrangeAllCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());
    }

    public static Set<String> arrangeAllCitiesBySet(List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(toSet());
    }

    public static List<Trader> arrangeTraderInCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
    }

    public static String arrangeTraderNamesByABC(List<Transaction> transactions) {
        return transactions.stream()
                .map(it -> it.getTrader().getName())
                .distinct()
                .sorted()
                //.reduce("", (n1, n2) -> n1 + n2);
                .collect(joining());
    }
}
