package com.hyungjunn.modern_java_in_action._09_refactoring;

import com.hyungjunn.modern_java_in_action._03_file.Run;

public class AnonymousToLambda {
    public static void main(String[] args) {
        int a = 10;
        // Lambda
        Runnable r2 = () ->{
            //int a = 20; // 람다 표현식에서는 shadowing 이 일어나지 않는다. 변수의 스코프가 람다를 둘러싼 메서드의 스코프와 같기 때문이다.
            System.out.println(a);
        };
        r2.run();

        // Anonymous class
        Runnable r1 = new Runnable() {
            int a = 20; // 익명 클래스에서는 shadowing 이 일어난다. 익명 클래스의 변수는 익명 클래스 내부에서만 유효하기 때문이다.
            @Override
            public void run() {
                System.out.println(a);
            }
        };
        r1.run();

        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

        // doSomething(() -> System.out.println("Danger danger!!"));
        doSomething((Runnable) () -> System.out.println("Danger danger!!"));
        doSomething((Task) () -> System.out.println("Danger danger!!"));
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }
}
