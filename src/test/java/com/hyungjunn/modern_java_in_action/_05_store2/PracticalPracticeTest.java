package com.hyungjunn.modern_java_in_action._05_store2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hyungjunn.modern_java_in_action._05_store2.Transactions.transactions;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticalPracticeTest {
    @Test
    void practice1() {
        List<Transaction> ascendingTransactionAt2011 = TransactionCalculator.organize(transactions);

        assertThat(ascendingTransactionAt2011).hasSize(2);
    }
}
