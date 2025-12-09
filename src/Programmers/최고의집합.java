package Programmers;

import java.util.Arrays;

public class 최고의집합 {

  public int[] solution(int n, int s) {
    if (s < n) {
      return new int[]{-1};
    }

    int[] answer = new int[n];

    int base = s / n;

    int remainder = s % n;

    Arrays.fill(answer, base);

    for (int i = n - remainder; i < n; i++) {
      answer[i]++;
    }
    return answer;
  }
}
