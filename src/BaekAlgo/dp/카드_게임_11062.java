package BaekAlgo.dp;

import java.io.*;
import java.util.*;

public class 카드_게임_11062 {

  // memoizationㅇ

  static int[] cards;

  static int[][][] dp;

  static int solve(int left, int right, boolean turn) {
    if (right == left) {
      if (turn) {
        return cards[left];
      } else {
        return 0;
      }
    }

    if (dp[left][right][turn ? 1 : 0] != -1) {
      return dp[left][right][turn ? 1 : 0];
    }

    int res;

    if (turn) {
      res = Math.max(solve(left + 1, right, false) + cards[left],
          solve(left, right - 1, false) + cards[right]);
    } else {
      res = Math.min(solve(left + 1, right, true),
          solve(left, right - 1, true));
    }

    return dp[left][right][turn ? 1 : 0] = res;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());

      cards = new int[N];

      dp = new int[N][N][2];

      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
          for (int z = 0; z < 2; z++) {
            dp[x][y][z] = -1;
          }
        }
      }

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        cards[j] = Integer.parseInt(st.nextToken());
      }

      sb.append(solve(0, N - 1, true)).append("\n");
    }

    System.out.println(sb);

  }
}
