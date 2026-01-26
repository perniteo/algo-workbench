package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파일_합치기_11066 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int c = 0; c < t; c++) {
      int chapter = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());

      long[] sum = new long[chapter + 1];

      for (int f = 1; f <= chapter; f++) {
        int file = Integer.parseInt(st.nextToken());
        sum[f] = sum[f-1] + file;
      }

      long[][] dp = new long[chapter+1][chapter+1];

      for (int i = 1; i <= chapter; i++) {
        for (int j = 1; j <= chapter; j++) {
          if (i == j) continue;
          dp[i][j] = Long.MAX_VALUE / 4;
        }
      }

      for (int len = 2; len <= chapter; len++) {
        for (int i = 1; i <= chapter - len + 1; i++) {
          int j = i + len - 1;

          for (int k = i; k < j; k++) {
            long cost = dp[i][k] + dp[k+1][j] + (sum[j] - sum[i - 1]);
            dp[i][j] = Math.min(dp[i][j], cost);
          }
        }
      }

      System.out.println(dp[1][chapter]);
    }

  }
}
