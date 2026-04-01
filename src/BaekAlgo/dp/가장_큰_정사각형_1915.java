package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 가장_큰_정사각형_1915 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] dp = new int[n][m];

    int result = 0;

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        dp[i][j] = str.charAt(j) - '0';
        if (dp[i][j] == 1) {
          result = 1;
        }
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (dp[i][j] == 1) {
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        }
        result = Math.max(dp[i][j], result);
      }
    }
    System.out.println(result * result);
  }
}
