package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.template_method;

abstract class OnlineBanking {

    // 각각의 지점들은 OnlineBanking 을 상속받아 makeCustomerHappy 를 커스텀한다.
    public void processCustomer(int id) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);

}
