package com.hyungjunn.modern_java_in_action._05_store2;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._05_store2.Traders.*;

public class Transactions {
    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
}
