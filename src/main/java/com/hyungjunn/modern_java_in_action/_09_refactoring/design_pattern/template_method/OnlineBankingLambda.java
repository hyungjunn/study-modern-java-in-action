package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.template_method;

import java.util.function.Consumer;

public class OnlineBankingLambda {

    public void processorCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }

}
