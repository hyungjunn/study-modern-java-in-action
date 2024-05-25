package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

public class TopLevelClass {
    void accessMembers(OuterClass outerClass) {
        // outerField is instance variable
        // System.out.println(OuterClass.outerField);
        System.out.println(outerClass.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}
