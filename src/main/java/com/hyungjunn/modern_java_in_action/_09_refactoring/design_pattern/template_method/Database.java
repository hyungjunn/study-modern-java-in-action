package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.template_method;

public class Database {

    public static Customer getCustomerWithId(int id) {
        return new Customer();
    }

}
