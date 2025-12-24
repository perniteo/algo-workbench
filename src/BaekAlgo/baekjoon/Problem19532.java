package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem19532 {

  // 브루트포스 기반 연립방정식
  // 크래머 공식을 사용하면 1차 연립 방정식의 해를 바로 구할 수 있다.
  // 행렬 -> 역행렬로 해를 구하는 것을 식으로 나타낸 것

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    int[] equation = Arrays.stream(input.split(" "))
        .mapToInt(Integer::parseInt).toArray();

    for (int i = -999; i < 1000; i++) {
      for (int j = -999; j < 1000; j++) {
        if (equation[0] * i + equation[1] * j == equation[2] &&
            equation[3] * i + equation[4] * j == equation[5]) {
          System.out.printf("%d %d", i, j);
          return;
        }
      }
    }

  }
}