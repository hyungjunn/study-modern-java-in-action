package com.hyungjunn.modern_java_in_action._02_apples.strategy;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import com.hyungjunn.modern_java_in_action._02_apples.ApplePredicate;

public class AppleRedColorAndLightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.isRed() && apple.isWeightAbove(0);
    }
}
