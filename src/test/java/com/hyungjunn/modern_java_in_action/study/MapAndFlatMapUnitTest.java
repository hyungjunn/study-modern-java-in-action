package com.hyungjunn.modern_java_in_action.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MapAndFlatMapUnitTest {
    @Test
    void givenStream_whenCalledMap_thenProduceList() {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .toList();

        assertThat(myList).isEqualTo(asList("A", "B"));
    }

    @Test
    void givenStream_whenCalledFlatMap_thenProduceFlattenedList() {
        List<List<String>> list = Arrays.asList(List.of("a"), List.of("b"));
        System.out.println(list); //[[a], [b]]

        List<String> myList = list.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("flattenedList: " + myList);
        // 여러개의 요소들을 하나로 압축? 시킨 것
    }

    @Test
    void givenOptional_whenCalledMap_thenProducedOptional() {
        Optional<String> s = Optional.of("test");
        assertThat(s.map(String::toUpperCase)).isEqualTo(Optional.of("TEST"));
    }

    @Test
    void givenOptional_whenCalledFlatMap_thenProducedFlattenedOptional() {
        Optional<Optional<String>> s1 = Optional.of("string")
                .map(s -> Optional.of("STRING"));
        assertThat(s1).isEqualTo(Optional.of(Optional.of("STRING")));

        Optional<String> s2 = Optional.of("string")
                .flatMap(s -> Optional.of("STRING"));
        assertThat(s2).isEqualTo(Optional.of("STRING"));
    }
}
