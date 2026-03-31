package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 양팔저울_2629 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int totalWeight = 0;

    int[] weight = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int w = Integer.parseInt(st.nextToken());

      weight[i] = w;
      totalWeight += w;
    }

    boolean[][] dp = new boolean[n + 1][totalWeight + 1];

    for (int i = 1; i <= n; i++) {
      int w = weight[i - 1];
      dp[i][w] = true;
      for (int j = 1; j <= totalWeight; j++) {
        if (dp[i-1][j]) {
          dp[i][j] = true;

          if (j + w <= totalWeight) {
            dp[i][j + w] = true;
          }

          dp[i][Math.abs(j - w)] = true;
        }
      }
    }

    int beads = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < beads; i++) {
      int bead = Integer.parseInt(st.nextToken());
      if (bead <= totalWeight && dp[n][bead]) {
        sb.append("Y");
      } else {
        sb.append("N");
      }
      sb.append(" ");
    }

    System.out.println(sb);
  }
}
