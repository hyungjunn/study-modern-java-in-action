package com.hyungjunn.modern_java_in_action._05_store2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.hyungjunn.modern_java_in_action._05_store2.Transactions.transactions;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticalPracticeTest {
    @Test
    void practice1() {
        List<Transaction> ascendingTransactionAt2011 = TransactionCalculator.organize(transactions);

        assertThat(ascendingTransactionAt2011).hasSize(2);
    }

    @Test
    void practice2_1() {
        List<String> cities = TransactionCalculator.arrangeAllCities(transactions);

        assertThat(cities).hasSize(2);
    }

    @Test
    void practice2_2() {
        Set<String> cities = TransactionCalculator.arrangeAllCitiesBySet(transactions);

        assertThat(cities).hasSize(2);
    }

    @Test
    void practice3() {
        List<Trader> tradersInCambridge = TransactionCalculator.arrangeTraderInCambridge(transactions);

        assertThat(tradersInCambridge).hasSize(3);
    }

    @Test
    void practice4() {
        String traderName = TransactionCalculator.arrangeTraderNamesByABC(transactions);

        assertThat(traderName).isEqualTo("AlanBrianMarioRaoul");
    }

    @Test
    void practice5() {
        boolean isTraderInMilan = TransactionCalculator.isTraderInMilan(transactions);

        assertThat(isTraderInMilan).isTrue();
    }

    @Test
    void practice6() {
        TransactionCalculator.printTransactionByCambridgeTrader(transactions);
    }

    @Test
    void practice7() {
        Integer maxValue = TransactionCalculator.maxValue(transactions)
                .orElseThrow();

        assertThat(maxValue).isEqualTo(1000);
    }
}
