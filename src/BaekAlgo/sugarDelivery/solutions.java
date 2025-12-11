package BaekAlgo.sugarDelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solutions {
// 설탕 배달


  // 	14244kb	104ms
  public static int dp(int n) {

    int[] dp = new int[n+1];

    Arrays.fill(dp, 500000);

    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      if (i >= 3) {
        dp[i] = Math.min(dp[i-3] + 1, dp[i]);
      }
      if (i >= 5) {
        dp[i] = Math.min(dp[i-5] + 1, dp[i]);
      }
    }
    if (dp[n] == 500000) {
      return -1;
    } else return dp[n];

  }
  // 14232kb	104ms
  public static int bruteForce(int n) {

    int answer = Integer.MAX_VALUE;

    for (int i = 0; i <= n / 5; i++) {
      int impl = n - (5 * i);
      if (impl % 3 == 0) {
        answer = Math.min(answer, i + (impl / 3));
      }
    }

    if (answer == Integer.MAX_VALUE) {
      return -1;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int answer = 0;

    int n = Integer.parseInt(br.readLine());

    System.out.println(bruteForce(n));

    System.out.println(dp(n));

    // 14176kb	108ms

    // greedy
    while (n != 0) {
      if (n == 1 || n == 2) {
        System.out.println(-1);
        return;
      }
      if (n % 5 == 0) {
        answer += n / 5;
        System.out.println(answer);
        return;
      }
      // 실패한 최적화
//      if (n > 15) {
//        int impl = (n / 15) * 3;
//        answer += impl;
//        n %= 15;
//      }
      n -= 3;
      answer++;
    }
    System.out.println(answer);
  }
}