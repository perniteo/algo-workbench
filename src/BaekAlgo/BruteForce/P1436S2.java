package BaekAlgo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436S2 {
  // 영화감독 숀
  // 메모리 사용을 최대로 줄이는 건 연산으로 끝내는 것
  // 브루트 포스로 모든 수를 검사하되 666포함 여부를 정수 계산으로 찾음
  // 메모리와 시간은 제일 좋은 결과

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;
    int curr = 665;

    int n = Integer.parseInt(br.readLine());

    while (count != n) {
      curr++;
      int impl = curr;
      while (impl > 0) {
        if (impl % 1000 == 666) {
          count++;
          break;
        }
        impl/=10;
      }
    }

    System.out.println(curr);
  }
}