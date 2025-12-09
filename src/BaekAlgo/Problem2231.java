package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2231 {

  // 분해합
  // N의 생성자 구하기
  // 시작 범위를 최적화하였음, 1부터 다 찾아도 통과

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int len = String.valueOf(n).length();

    int start = Math.max(1, n - (9 * len));

    for (int i = start; i <= n; i++) {
      int sum = 0;
      int curr = i;
      while (curr > 0) {
        sum += curr % 10;
        curr /= 10;
      }
      if (i + sum == n) {
        System.out.println(i);
        return;
      }
    }
    System.out.println(0);
  }
}