# 모던 자바 인 액션 스터디

* 교재: [모던 자바 인 액션 : 람다, 스트림, 함수형, 리액티브 프로그래밍으로 새로워진 자바 마스터하기
  ](https://m.hanbit.co.kr/store/books/book_view.html?p_code=B4926602499)
* 참여자: @hyungjunn

이 스터디의 특징은 다음과 같다.

* 스터디 양식은 [@johngrib(기계 인간 John Grib)님의 오브젝트 스터디](https://github.com/johngrib/study-objects)를 따른다.
* 책의 모든 코드를 직접 입력해본다.
* 새로운 모던 자바의 문법을 배우는 것이 목적인 만큼 학습 테스트를 작성한다.
* 객체지향적인 코드로 리팩토링한다.
* 단계별로 git commit 을 하여, 책을 읽으면서 순서대로 따라올 수 있도록 한다.

## chapter 1. 자바 8, 9, 10, 11 : 무슨 일이 일어나고 있는가?

이 챕터는 핵심적으로 바뀐 자바 기능(람다 표현식, 메서드 참조, 스트림, 디폴트 메서드)과 책의 전체 흐름을 설명한다.

코드 예제는 생략한다.

## chapter 2. 동작 파라미터화 코드 전달하기

이 챕터는 요구 사항이 바뀜에 따른 해결 방법을 제시한다. 동작 파라미터화를 통해 코드를 전달하는 방법을 설명한다. 이 책에선 `문제 -> 해결` 방식으로 설명을 계속 해나간다. 

1. 값 파라미터화 
* P: 요구 사항에 유연하게 대처하지 못한다
* S: 동작을 파라미터화하여 코드를 전달하는 방법을 제시한다.

2. Predicate 를 이용한 전략패턴을 통해 다양한 동작을 수행하게 한다.
* P: 계속 클래스를 만들어야 한다.
* S: 익명 클래스를 이용하여 클래스 선언과 인스턴스화를 동시에 할 수 있게 한다.

3. 익명 클래스
* P: 코드가 장황해진다.
* S: 람다 표현식을 이용하여 코드를 간결하게 한다.

4. 람다 표현식 

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/1 )

## chapter 3. 람다 표현식

람다 표현식에 대해 중점적으로 배운다.

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/2 )

## chapter 4. 스트림 소개

스트림이 무엇인지에 대해 배운다.

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/3 )

## chapter 5. 스트림 활용

스트림 API 가 지원하는 다양한 연산을 살펴본다. 

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/4 )

## chapter 6. 스트림으로 데이터 수집

collect 가 다양한 요소 누적 방식을 인수로 받아서 스트림을 최종 결과로 도출하는 리듀싱 연산을 수행할 수 있음을 설명한다. 

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/5 )

## chapter 7. 병렬 데이터 처리와 성능

스트림으로 데이터 컬렉션 관련 동작을 얼마나 쉽게 병렬로 실행할 수 있는지 설명한다.

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/6 )

## chapter 8. 컬렉션 API 개선

자바 8, 9에서 추가된 컬렉션 API 개선 사항을 살펴본다.

* [학습 내용]( https://github.com/hyungjunn/study-modern-java-in-action/pull/7 )

## chapter 9. 리팩터링, 테스팅, 디버깅

람다 표현식을 이용해 어떻게 리팩터링하는지 살펴본다.
람다 표현식으로 디자인 패턴을 어떻게 간소화 할 수 있는지도 살펴본다.
코드를 더 효과적으로 테스팅, 디버깅하는 방법을 설명한다.
