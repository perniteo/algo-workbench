package BaekAlgo.dp;

import java.io.*;

public class 푸앙이와_콩나무_33677 {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      int[][] dp = new int[n+1][2];

      for (int i = 1; i <= n; i++) {
        dp[i][0] = 10_000_000;
        dp[i][1] = 10_000_000;
      }

      for (int i = 1; i <= n; i++) {
        if (dp[i - 1][0] + 1 < dp[i][0]) {
          dp[i][0] = dp[i - 1][0] + 1;
          dp[i][1] = dp[i - 1][1] + 1;
        }

        if (i % 3 == 0 && dp[i / 3][0] + 1 < dp[i][0]) {
          dp[i][0] = dp[i / 3][0] + 1;
          dp[i][1] = dp[i / 3][1] + 3;
        }

        double sqrt = Math.sqrt(i);

        if (sqrt % 1 == 0 && dp[(int) sqrt][0] + 1 < dp[i][0]) {
          dp[i][0] = dp[(int) sqrt][0] + 1;
          dp[i][1] = dp[(int) sqrt][1] + 5;
        }
      }

      System.out.println(dp[n][0] + " " + dp[n][1]);

    }
  }
