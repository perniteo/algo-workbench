package BaekAlgo.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수_구하기_1929 {

  // 에라토스테네스의 체


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());

    int n = Integer.parseInt(st.nextToken());

    boolean[] isNotPrime = new boolean[n + 1];

    isNotPrime[1] = true;

    for (int i = 2; i <= n / i; i++) {

      if (isNotPrime[i]) continue;

      for (int j = i * i; j <= n; j += i) {
        isNotPrime[j] = true;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = m; i <= n; i++) {
      if (!isNotPrime[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb);

  }
}