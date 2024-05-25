package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum Product {
    LOAN,
    STOCK,
    BOND;

    final static public Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", () -> LOAN);
        map.put("stock", () -> STOCK);
        map.put("bond", () -> BOND);
    }
}
