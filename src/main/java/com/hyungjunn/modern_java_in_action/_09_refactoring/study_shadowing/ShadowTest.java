package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

public class ShadowTest {
    public int x = 0;

    class FirstLevel {
        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);                                 // 23
            System.out.println("this.x = " + this.x);                       // 1
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x); // 0
        }
    }

    public static void main(String[] args) {
        ShadowTest st = new ShadowTest();
        FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
