package BaekAlgo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436S {
  // 영화감독 숀
  // 정규식 엔진을 쓰지 않고 제일 단순하게 String.contains 메소드 사용
  // 결과는 통과

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;
    int curr = 665;

    int n = Integer.parseInt(br.readLine());

    while (count != n) {
      curr++;
      if (String.valueOf(curr).contains("666")) {
        count++;
      }
    }

    System.out.println(curr);
  }
}