package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.factory;

import org.junit.jupiter.api.Test;

import static com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.factory.Product.LOAN;
import static org.assertj.core.api.Assertions.assertThat;

class ProductFactoryTest {

    @Test
    void test() {
        Product loan = ProductFactory.createProduct("loan");
        assertThat(loan).isEqualTo(LOAN);
    }

    @Test
    void testLambda() {
        Product loan = ProductFactory.createProductLambda("loan");
        assertThat(loan).isEqualTo(LOAN);
    }
}
