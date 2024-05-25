package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.observer;

public class NYTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}
