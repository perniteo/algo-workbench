package Programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 숫자게임 {

  public static int solution2(int[] A, int[] B) {

    int answer = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    int aIndex = 0;
    int bIndex = 0;
    int aEnd = A.length - 1;

    while (aIndex <= aEnd && bIndex < B.length) {
      if (B[bIndex] > A[aIndex]) {
        answer++;
        aIndex++;
        bIndex++;
      } else {
        aEnd--;
        bIndex++;
      }
    }

    return answer;
  }


  public static int solution(int[] A, int[] B) {

    int answer = 0;

    int n = A.length;

    Arrays.sort(A);
    Arrays.sort(B);

    Deque<Integer> a = new LinkedList<>();
    Deque<Integer> b = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      a.add(A[i]);
      b.add(B[i]);
    }

    while (!a.isEmpty()) {
      if (b.peekFirst() > a.peekFirst()) {
        a.poll();
        b.poll();
        answer++;
      } else {
        a.pollLast();
        b.poll();
      }
    }

    return answer;
  }
}


