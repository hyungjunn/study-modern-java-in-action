package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

/*
Anonymous class Advantage:
declare and instantiate a class at the same time!

And anonymous classes are expressions
 */
public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    String name = "hyungjunn"; // effectively final

    public void sayHello() {
        // Local class
        class EnglishGreeting implements HelloWorld {
            String name = "world";

            @Override
            public void greet() {
                System.out.println(name);
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        EnglishGreeting englishGreeting = new EnglishGreeting();
        englishGreeting.greet();

        // Anonymous class
        HelloWorld spanishGreeting = new HelloWorld() {
            // shadow "hyungjunn"
            String name = "mundo";

            @Override
            public void greet() {
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola " + name);
            }
        };
        spanishGreeting.greet();

        // Anonymous class
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
        frenchGreeting.greet();

    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
