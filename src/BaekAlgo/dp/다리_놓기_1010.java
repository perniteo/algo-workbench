package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_놓기_1010 {
  
  // 조합 -> 점화식 -> dp
  // 간단하게 조합으로만 계산하기에는 overflow가 너무 심함
  // ex) 29!
  // 점화식의 규칙에 맞게 dp를 구현하고 누적할 수 있음

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int x = 0; x < t; x++) {
      st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());

      int m = Integer.parseInt(st.nextToken());

      int[][] dp = new int[m+1][n+1];

      for (int i = 0; i <= m; i++) {
        dp[i][0] = 1;
        for (int j = 1; j <= Math.min(i, n); j++) {
          if (j == i) {
            dp[i][j] = 1;
          } else {
          dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
          }
        }
      }

      sb.append(dp[m][n]).append("\n");
    }

    System.out.println(sb);
  }
}