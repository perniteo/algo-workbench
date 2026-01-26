package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 내리막_길_1520 {

  // 탐색 방법 - dfs + pruning
  // 계산 모델 - dp(memoization)

  static int[] dr = new int[]{-1, 1, 0, 0};
  static int[] dc = new int[]{0, 0, -1, 1};

  static int[][] dp;
  static int[][] map;

  static int m;
  static int n;

  static int dfs(int r, int c) {
    if (r == m - 1 && c == n - 1) return 1;

    if (dp[r][c] != -1) return dp[r][c]; // pruning

    dp[r][c] = 0;

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

      if (map[r][c] > map[nr][nc]) {
        dp[r][c] += dfs(nr, nc);
      }

    }

    return dp[r][c];
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    dp = new int[m][n];
    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }

    map = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int h = Integer.parseInt(st.nextToken());
        map[i][j] = h;
      }
    }

    System.out.println(dfs(0, 0));

    for (int[] d : dp) {
      for (int p : d) {
        System.out.print(p + " ");
      }
      System.out.println();
    }

  }
}
