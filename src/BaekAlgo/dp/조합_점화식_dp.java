package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_점화식_dp {
  
  // 조합에 대한 기초 그것을 점화식으로 표현하고 그것을 dp로 또 다시 표현하는 것
  // 점화식의 변수가 곧 dp의 차원을 의미함
  // dp는 각 상태를 표현하는 배열임

  public static int factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return factorial(n - 1) * n;
  }

  public static long factorial2(int n) {
    long result = 1;

    for (int i = 1; i <= n; i++) {
      result *= i;
    }

    return result;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    System.out.println(factorial2(n) / (factorial2(n - k) * factorial2(k)));

    int[][] dp = new int[n + 1][k + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;

      for (int j = 1; j <= Math.min(i, k); j++) {
        if (j == i) {
          dp[i][j] = 1;
        } else {
        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
        }
      }
    }

    int[] dp2 = new int[k + 1];

    dp2[0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, k); j > 0; j--) {
        dp2[j] = dp2[j] + dp2[j - 1];
      }
    }

    System.out.println(dp2[k]);
  }
}