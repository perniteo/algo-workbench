# Java Deque 고찰 정리 (의미 중심)

## 1. 자료구조의 본질

### Stack (스택)
- LIFO (Last In, First Out)
- 핵심은 같은 쪽에서 넣고 같은 쪽에서 뺀다는 점
- front / back 어느 쪽인지는 본질적으로 중요하지 않다

### Queue (큐)
- FIFO (First In, First Out)
- 핵심은 넣는 쪽과 빼는 쪽이 다르다는 점
- 방향은 개념이 아니라 역할 분리의 문제다

---

## 2. Deque란?
Deque (Double Ended Queue)는
앞(front)과 뒤(back) 양쪽에서 삽입/삭제가 가능한 컨테이너다.

Deque 자체에는
- 스택 의미 없음
- 큐 의미 없음

어떤 메서드를 사용하느냐에 따라 의미가 결정된다.

---

## 3. Java Deque의 기준 정의

Java Deque는 내부적으로 두 끝을 다음과 같이 정의한다.

- first : 한쪽 끝
- last  : 반대쪽 끝

Java는 스택의 top을 first로 정의했다.
이는 설계 선택이며 개념적 필연은 아니다.

---

## 4. Java Deque를 Stack으로 사용할 때 (LIFO)

사용 메서드
- push(e)
- pop()
- peek()

의미
- push : first에 삽입
- pop  : first에서 제거
- peek : first 확인

정리
- 같은 쪽(first)에서 넣고 빼기
- LIFO (스택)

중요
- push/pop이 first를 쓰는 것은 설계 선택
- last를 써도 스택 의미는 동일했을 것
- 중요한 건 같은 쪽이라는 점이다

---

## 5. Java Deque를 Queue로 사용할 때 (FIFO)

사용 메서드
- offer(e)
- poll()
- peek()

의미
- offer : last에 삽입
- poll  : first에서 제거
- peek  : first 확인

정리
- 뒤에 넣고(last)
- 앞에서 빼기(first)
- FIFO (큐)

---

## 6. 방향을 명시하는 API (가장 명확)

- addFirst(e)
- addLast(e)
- pollFirst()
- pollLast()
- peekFirst()
- peekLast()

front / back을 직접 지정한다.
방향이 중요한 구현에서는 가장 명확한 방법이다.

---

## 7. poll 과 pop 차이

공통점
- 제거 위치는 first로 동일하다

차이점
- pop  : 비어 있으면 예외 발생
- poll : 비어 있으면 null 반환

의미(LIFO/FIFO)와는 무관한 차이다.

---

## 8. 다른 언어와의 차이 (혼란의 원인)

대부분의 언어
- C++ stack
- Python list
- JavaScript Array

공통 인식
- push/pop은 끝(back) 기준

Java Deque
- push/pop은 first 기준

이 차이 때문에 처음 보면 의미가 반대로 느껴진다.

---

## 9. 왜 Java는 이렇게 설계했나

- Deque 하나로 Stack과 Queue를 통합
- 스택의 top을 first로 고정
- 큐는 first / last로 역할 분리

의미(LIFO / FIFO)를
방향이 아니라 API 이름으로 구분하는 설계다.

---

## 10. 실전 사용 규칙

- 스택 의미 : push / pop
- 큐 의미   : offer / poll
- 방향 명시 : addFirst / addLast

방향을 외우지 말고
의미(LIFO / FIFO) 기준으로 선택한다.

---

## 11. 최종 고찰

Java Deque는 의미가 깨진 구조가 아니다.
의미를 API 이름에 위임한 구조다.

혼란은 방향(front/back)에 집착할 때 생긴다.

스택의 본질은
- 끝이 아니라
- 같은 쪽이다

---

## 12. 한 줄 요약

Java Deque는
방향이 아니라
의미로 읽어야 한다
