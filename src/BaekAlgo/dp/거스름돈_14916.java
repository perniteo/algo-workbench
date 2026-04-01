package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 거스름돈_14916 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];

    int INF = 1_000_000;

    Arrays.fill(dp, INF);

    dp[0] = 0;

    for (int i = 2; i <= n; i++) {
      if (dp[i - 2] != INF) {
        dp[i] = Math.min(dp[i - 2] + 1, dp[i]);
      }

      if (i >= 5 && dp[i - 5] != INF) {
        dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
      }
    }

    if (dp[n] >= INF) {
      System.out.println(-1);
    } else {
      System.out.println(dp[n]);
    }

  }
}
