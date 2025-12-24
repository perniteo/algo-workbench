package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11653 {

  // 간단한 소인수분해
  // 리팩토링 여지 많음

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int divide = 2;

    while (N > 1) {

      while (N % divide == 0) {
        N /= divide;
        System.out.println(divide);
      }
      divide++;
    }
  }
}


