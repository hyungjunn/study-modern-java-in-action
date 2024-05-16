package com.hyungjunn.modern_java_in_action._07_parallel;

import java.util.Objects;

public class WordCounter {
    private final int count;
    private final boolean lastSpace;

    public WordCounter(int count, boolean lastSpace) {
        this.count = count;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(char c) {
        if (Character.isWhitespace(c)) {
            return this.lastSpace ? this : new WordCounter(this.count, true);
        }
        return this.lastSpace ? new WordCounter(this.count + 1, false) : this;
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

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(this.count + wordCounter.count, wordCounter.lastSpace);
    }
}
