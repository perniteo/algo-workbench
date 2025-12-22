# Java Stable Sort & TimSort 정리

## 1. Stable Sort(안정 정렬)이란?

**Stable Sort**란  
정렬 기준 값이 같은 요소들에 대해 **입력 순서를 유지하는 정렬**이다.

예시:

```java
입력:
(20, A), (20, B), (30, C)

정렬 (age 기준):
(20, A), (20, B), (30, C) ← A가 B보다 앞에 유지됨
```

안정 정렬이 필요한 경우:
- 입력 순서가 의미를 가질 때
- 다중 조건 정렬 (1차, 2차 정렬)
- 문제에서 “가입 순”, “먼저 나온 순서 유지”가 요구될 때

---

## 2. Java에서 Stable Sort 보장 여부

### 2.1 Collections.sort / List.sort

```java
Collections.sort(list);
list.sort(comparator);
```

* 내부 구현: **TimSort**

* 정렬 대상: `List`

* **안정 정렬 보장 (Stable)**

Java 8 이후:

* `Collections.sort()`는 내부적으로 `list.sort()` 호출

* 결과 및 성능 차이 없음

2.2 Arrays.sort
1️⃣ primitive 배열
Arrays.sort(int[]);


내부 구현: Dual-Pivot QuickSort

안정 정렬 아님 (Unstable)

2️⃣ 객체 배열
Arrays.sort(Member[]);


내부 구현: TimSort

안정 정렬 보장

2.3 정리 표
정렬 메서드	대상	내부 알고리즘	Stable
List.sort	List	TimSort	✅
Collections.sort	List	TimSort	✅
Arrays.sort	primitive 배열	Dual-Pivot QuickSort	❌
Arrays.sort	객체 배열	TimSort	✅
3. Primitive가 Stable하지 않은 이유

❌ primitive라서 stable sort가 불가능한 것이 아님
⭕ 정렬 알고리즘 선택의 문제

primitive 배열 정렬:

성능, 메모리 효율 우선

QuickSort 계열 선택 → unstable

객체 / List 정렬:

안정성 + 실전 데이터 최적화

TimSort 선택 → stable

4. TimSort란?

TimSort = Merge Sort + Insertion Sort 기반의 안정 정렬 알고리즘

Python, Java(List / Object 배열)의 표준 정렬

실제 데이터(부분 정렬된 경우)에 매우 강함

처음부터 안정 정렬을 목표로 설계됨

5. TimSort가 Stable한 이유
   핵심: Merge 단계의 규칙

두 정렬된 구간(left, right)을 병합할 때
비교 결과가 같으면 무조건 left를 먼저 선택

left:  [A1, A2]
right: [B1, B2]

A1 == B1 인 경우
→ 결과: A1, B1


left = 먼저 등장한 구간

right = 나중에 등장한 구간

같은 값일 때 입력 순서 유지

→ 구조적으로 stable 보장

6. TimSort에서 Insertion Sort는 언제 쓰이나?
   사용 시점

발견한 run(이미 정렬된 구간)의 길이가 MIN_RUN보다 짧을 때

Java 기준:

MIN_RUN ≈ 32 ~ 64

역할

짧고 거의 정렬된 구간을 빠르게 정리

Insertion Sort는:

작은 구간에서 빠름

stable

구현 단순

7. TimSort 전체 흐름

배열을 순회하며 이미 정렬된 run 탐색

run이 짧으면 → Insertion Sort로 길이 보강

충분한 길이의 run들을 → Merge

모든 병합 과정에서 안정성 유지

8. 정리 한 문장

TimSort는 merge sort를 베이스로 하되,
실제 데이터 최적화를 위해 insertion sort를 섞은
안정 정렬 알고리즘이다.

9. 실전 사용 가이드

입력 순서 유지 필요 → List.sort() / Collections.sort()

객체 배열 정렬 → Arrays.sort(Object[])

primitive + 성능 우선 → Arrays.sort(primitive[])

안정 정렬 문제에서 primitive 배열 정렬은 주의