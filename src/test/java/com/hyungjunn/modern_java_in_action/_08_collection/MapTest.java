package com.hyungjunn.modern_java_in_action._08_collection;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Map.entry;
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
}
