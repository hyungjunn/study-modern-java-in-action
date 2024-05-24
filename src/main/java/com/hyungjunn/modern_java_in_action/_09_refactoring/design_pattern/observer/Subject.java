package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.observer;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObserver(String tweet);
}
