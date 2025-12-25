# Josephus (Deque) 리팩토링 메모

---
**before**
``` java
    while (!queue.isEmpty()) {
      if (c == k) {
        int eliminated = queue.poll();
        sb.append(eliminated).append(" ");
        c = 1;
      } else {
        queue.offer(queue.poll());
        c++;
      }
    }
```
**after**
``` java
    while (!queue.isEmpty()) {
      for (int i = 0; i < k - 1; i++) {
        queue.offer(queue.poll());
      }
      int eliminated = queue.poll();

      sb.append(eliminated);

      if (!queue.isEmpty()) {
        sb.append(", ");
      }
    }
```
---

## 기존 사고
- count 변수를 두고 k번째를 제거
- poll / offer로 회전하며 상태 유지

## 문제점
- 상태 변수(c)가 규칙을 직접 표현하지 못함
- 분기(if/else)가 필요함

## 핵심 규칙 재정의
- 요세푸스는 "k-1번 이동 후 제거" 문제

## 리팩토링
- count 제거
- for문으로 k-1번 회전 후 제거

## 결론
- index가 없는 자료구조는 '회전'으로 대체 가능
- 상태보다 규칙을 코드 구조로 표현하는 게 더 명확함
