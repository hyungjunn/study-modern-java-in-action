package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

public class LocalClassExample {
    // static 으로 선언되어 있어야 validatePhoneNumber 가 쓸 수 있다
    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(
            String phoneNumber1, String phoneNumber2
    ) {
        // 바깥 스코프에서 final 을 선언하지 않아도
        // 재선언이 불가하는데, 이런걸 effective final 이라고 불리운다.
        int numberLength = 10; // local variable

        class PhoneNumber {
            // 참고: (https://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html)
            // local class 에 static declarations 가 안된다고 했으나,
            // 선언이 가능해짐(rf. JEP384)
            static int staticField;
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
                // 위의 local variable 끌어와서 쓴다고 해서
                // capturing 이라고 불리운다
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            public void printOriginalNumbers() {
                // Java 8 부터 local class 를 감싸는 메서드의 파라미터도 끌어와다 쓸 수 있다
                // 이것 역시 capturing 한다고 한다.
                System.out.println("Original numbers are " + phoneNumber1 + " and " +
                                   phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null) {
            System.out.println("First number is invalid");
        } else {
            System.out.println("First number is " + myNumber1.getNumber());
        }

        if (myNumber2.getNumber() == null) {
            System.out.println("Second number is invalid");
        } else {
            System.out.println("Second number is " + myNumber2.getNumber());
        }
    }

    public void nonStaticMethod() {
        class InnerClass {
            static int staticVariable;
        }
    }

    public static void main(String[] args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
