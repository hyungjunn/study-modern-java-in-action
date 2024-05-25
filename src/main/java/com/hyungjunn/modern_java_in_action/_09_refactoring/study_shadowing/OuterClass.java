package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

public class OuterClass {
    String outerField = "Outer field";

    static String staticOuterField = "Static Outer field";

    public static void main(String[] args) {
        System.out.println("Inner Class:");
        System.out.println("------------");
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        innerClass.accessMembers();

        System.out.println("\nStatic Nested Class:");
        System.out.println("---------------------");
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        staticNestedClass.accessMembers();
        System.out.println("<This is the way to referenced from a static context>");
        staticNestedClass.accessMembers(outerClass);

        System.out.println("\nTop-level class:");
        System.out.println("-------------------");
        TopLevelClass topLevelClass = new TopLevelClass();
        topLevelClass.accessMembers(outerClass);
    }

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers() {
            // outerField cannot be referenced from a static context
            // System.out.println(outerField);
            System.out.println(staticOuterField);
        }

        // just like any other top-level class,
        // a static nested class interacts with the instance members of its outer class
        void accessMembers(OuterClass outerClass) {
            System.out.println(outerClass.outerField);
        }
    }
}
