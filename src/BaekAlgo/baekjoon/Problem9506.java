package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Problem9506 {

  // 약수들의 합을 이용해 완전수 찾기
  // 찾고 출력 format 지정하기
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      ArrayList<Integer> factors = new ArrayList<>();

      int num = Integer.parseInt(br.readLine());

      if (num == -1) {
        break;
      }

      for (int i = 1; i <= Math.sqrt(num); i++) {
        if (num % i == 0) {
          factors.add(i);
          if (i != num / i) {
            factors.add(num / i);
          }
        }
      }
      Collections.sort(factors);

      factors.remove(Integer.valueOf(num));

      int sum = factors.stream().mapToInt(Integer::intValue).sum();
      System.out.println(sum);

      StringBuilder sb = new StringBuilder();

      sb.append(num);

      if (sum == num) {
        sb.append(" = ").append(factors.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" + ")));
      } else {
        sb.append(" is NOT perfect.");
      }

      System.out.println(sb);

    }
  }
}

