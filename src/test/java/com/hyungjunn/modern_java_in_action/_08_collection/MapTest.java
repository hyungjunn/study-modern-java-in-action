package com.hyungjunn.modern_java_in_action._08_collection;

import com.hyungjunn.modern_java_in_action._07_parallel.ParallelStreams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
    @Test
    void testMapFactoryMethod() {
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

        assertThat(ageOfFriends.get("Raphael")).isEqualTo(30);
        assertThat(ageOfFriends.get("Olivia")).isEqualTo(25);
        assertThat(ageOfFriends.get("Thibaut")).isEqualTo(26);
    }

    @Test
    void testMapEntry() {
        // 열 개 보다 더 많은 키와 값 쌍을 가질 때는
        // 가변 인수로 구현된
        // Map.ofEntries 메서드를 사용하는 것이 좋다
        // 사용할 땐, 키와 값을 감싼 추가 객체 할당이 필요하다.
        Map<String, Integer> ageOfFriends =
                Map.ofEntries(entry("Raphael", 30),
                        entry("Olivia", 25),
                        entry("Thibaut", 26));

        assertThat(ageOfFriends.get("Raphael")).isEqualTo(30);
        assertThat(ageOfFriends.get("Olivia")).isEqualTo(25);
        assertThat(ageOfFriends.get("Thibaut")).isEqualTo(26);
    }

    @Test
    void testEntryComparingByKey() {
        Map<String, String> favouriteMovies = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bonds"));

        favouriteMovies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);
    }

    @Test
    void testEntryComparingByValue() {
        Map<String, String> favouriteMovies = Map.ofEntries(entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bonds"));

        favouriteMovies.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println);
    }

    @Test
    void testGetOrDefault() {
        Map<String, String> favouriteMovies = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Olivia", "James Bonds"));

        assertThat(favouriteMovies.getOrDefault("Olivia", "Matrix")).isEqualTo("James Bonds");
        assertThat(favouriteMovies.getOrDefault("Thibaut", "Matrix")).isEqualTo("Matrix");
    }

    @Test
    void testComputeIfAbsent() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }
        movies.add("Star Wars");

        assertThat(friendsToMovies.get("Raphael")).isEqualTo(List.of("Star Wars"));

        // computeIfAbsent 적용
        friendsToMovies.computeIfAbsent("Karina", name -> new ArrayList<>())
                .add("Pretty Idol");

        assertThat(friendsToMovies.get("Karina")).isEqualTo(List.of("Pretty Idol"));
    }

    @Test
    void testRemoveBeforeJava8() {
        Map<String, String> favouriteMovies = new HashMap<>();

        String key = "Raphael";
        String value = "Jack Reacher2";

        favouriteMovies.put(key, value);
        favouriteMovies.remove(key, value);

        assertThat(favouriteMovies).isEqualTo(new HashMap<>());
    }

    @Test
    void testReplaceAll() {
        Map<String, String> favouriteMovies = new HashMap<>();

        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");

        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());

        assertThat(favouriteMovies.get("Raphael")).isEqualTo("STAR WARS");
        assertThat(favouriteMovies.get("Olivia")).isEqualTo("JAMES BOND");
    }

    @Test
    void testPutAll() {
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond"));

        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars"));

        HashMap<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);

        assertThat(everyone.get("Raphael")).isEqualTo("Star Wars");
    }

    @Test
    void testMerge() {
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond"));

        Map<String, String> friends = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"));

        HashMap<String, String> everyone = new HashMap<>(family);
        friends.forEach((k, v) ->
                everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));

        assertThat(everyone.get("Cristina")).isEqualTo("James Bond & Matrix");
    }
}
