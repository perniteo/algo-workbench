package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem24313 {
  // big-O, O(n)의 정의에 부합하는지 검사
  // 작은 값에서 나오는 예외를 볼 수 있음

  // Big‑O는 “충분히 큰 n" 이후의 성질만 보장하면 되기 때문이라고 함

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a1 = Integer.parseInt(st.nextToken());
    int a2 = Integer.parseInt(st.nextToken());

    int c = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    if (a1 <= c && (a1 * n) + a2 <= c * n) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}