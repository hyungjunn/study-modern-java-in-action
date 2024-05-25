package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.template_method;

import org.junit.jupiter.api.Test;

class OnlineBankingLambdaTest {

    @Test
    void test() {
        new OnlineBankingLambda().processorCustomer(1000, (Customer c) -> System.out.println("Happy!!!"));
    }
}
