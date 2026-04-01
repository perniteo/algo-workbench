package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 욕심쟁이_판다_1937 {

  // DP, MEMOIZATION(dfs)

  static int[][] dp;

  static int[][] forest;

  static int n;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int dfs(int x, int y) {
    if (dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 1;

    for (int i = 0; i < 4; i++) {
      int nr = x + dr[i];
      int nc = y + dc[i];

      if (nr < 0 || nc < 0 || nr >= n || nc >= n || forest[nr][nc] <= forest[x][y]) {
        continue;
      }

      dp[x][y] = Math.max(dfs(nr, nc) + 1, dp[x][y]);
    }

    return dp[x][y];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    forest = new int[n][n];

    dp = new int[n][n];

    int maxMove = 0;

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int info = Integer.parseInt(st.nextToken());

        forest[i][j] = info;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maxMove = Math.max(maxMove, dfs(i, j));
      }
    }

    System.out.println(maxMove);

  }
}
