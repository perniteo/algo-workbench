package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem10101 {
  // 삼각형 판별기
  // switch-case 사용시 case 마다 break 넣는 것 유의

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Set<Integer> angle = new HashSet<>();

    int sumAngle = 0;

    for (int i = 0; i < 3; i++) {
      int x = Integer.parseInt(br.readLine());

      angle.add(x);
      sumAngle += x;
    }

    if (sumAngle == 180) {
      switch (angle.size()) {
        case 1:
          System.out.println("Equilateral");
          break;
        case 2:
          System.out.println("Isosceles");
          break;
        case 3:
          System.out.println("Scalene");
          break;
      }
    } else {
      System.out.println("Error");
    }
  }
}