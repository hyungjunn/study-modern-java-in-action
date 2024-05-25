package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.observer;

import org.junit.jupiter.api.Test;

class FeedTest {

    @Test
    void test() {
        Feed feed = new Feed();
        feed.registerObserver(new NYTimes());
        feed.registerObserver(new Guardian());
        feed.registerObserver(new LeMonde());
        feed.notifyObserver("The queen her favorite book is Modern Java in Action");
    }

    @Test
    void testLambda() {
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("hyungjunn")) {
                System.out.println( "This is a " + tweet);
            }
        });
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("carmack")) {
                System.out.println( "This is a " + tweet);
            }
        });
        feed.notifyObserver("hyungjunn");
        feed.notifyObserver("John carmack");
    }
}
