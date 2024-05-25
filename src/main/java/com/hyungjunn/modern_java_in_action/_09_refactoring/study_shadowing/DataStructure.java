package com.hyungjunn.modern_java_in_action._09_refactoring.study_shadowing;

import java.util.Iterator;

public class DataStructure {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends Iterator<Integer> {

    }

    // 이렇게 로직 구현에 도움을 주는 helper class 를 만들 때, Inner class 가 제격
    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        @Override
        public Integer next() {
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String[] args) {
        DataStructure dataStructure = new DataStructure();
        dataStructure.printEven();
    }
}
