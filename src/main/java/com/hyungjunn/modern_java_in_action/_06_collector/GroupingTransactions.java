package com.hyungjunn.modern_java_in_action._06_collector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hyungjunn.modern_java_in_action._06_collector.Transactions.transactions;
import static java.util.stream.Collectors.groupingBy;

public class GroupingTransactions {
    public static Map<Currency, List<Transaction>> groupImperatively() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }
        return transactionsByCurrencies;
    }

    public static Map<Currency, List<Transaction>> groupFunctionally() {
        return transactions.stream()
                .collect(groupingBy(Transaction::getCurrency));
    }
}
