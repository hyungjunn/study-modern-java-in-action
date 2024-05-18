package com.hyungjunn.modern_java_in_action._07_parallel;

import java.util.Objects;
import java.util.stream.Stream;

public class WordCounter {
    private final int count;
    private final boolean lastSpace;

    public WordCounter(int count, boolean lastSpace) {
        this.count = count;
        this.lastSpace = lastSpace;
    }

    public static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.count;
    }

    public WordCounter accumulate(char c) {
        if (Character.isWhitespace(c)) {
            return this.lastSpace ? this : new WordCounter(this.count, true);
        }
        return this.lastSpace ? new WordCounter(this.count + 1, false) : this;
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(this.count + wordCounter.count, wordCounter.lastSpace);
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WordCounter that = (WordCounter) object;
        return count == that.count && lastSpace == that.lastSpace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, lastSpace);
    }
}
