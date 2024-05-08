package com.hyungjunn.modern_java_in_action._06_collector;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupingTransactionsTest {
    @Test
    void testImperatively() {
        Map<Currency, List<Transaction>> transactions = GroupingTransactions.groupImperatively();

        assertThat(transactions).hasSize(5);

        for (Currency currency : Currency.values()) {
            assertThat(transactions.containsKey(currency));
        }
    }

    @Test
    void testFunctionally() {
        Map<Currency, List<Transaction>> transactions = GroupingTransactions.groupFunctionally();

        assertThat(transactions).hasSize(5);

        for (Currency currency : Currency.values()) {
            assertThat(transactions.containsKey(currency));
        }
    }
}
