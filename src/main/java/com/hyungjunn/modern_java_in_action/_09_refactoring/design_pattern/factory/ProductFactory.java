package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.factory;

import java.util.function.Supplier;

import static com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.factory.Product.*;

public class ProductFactory {
    public static Product createProduct(String name) {
        return switch (name) {
            case "loan" -> LOAN;
            case "stock" -> STOCK;
            case "bond" -> BOND;
            default -> throw new RuntimeException("No such product " + name);
        };
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }
}
