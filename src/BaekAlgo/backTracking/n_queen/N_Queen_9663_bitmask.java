package BaekAlgo.backTracking.n_queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663_bitmask {

  // n-queen) backtracking -> bitmask 구현
  // 상태를 dfs recursion 하면서 계산하면서 넘김

  static int cnt = 0;

  static int n;

  public static void dfs(int row, int colMask, int d1Mask, int d2Mask) {
    if (row == n) {
      cnt++;
      return;
    }

    for (int c = 0; c < n; c++) {
      int cBit = 1 << c;
      int d1Bit = 1 << (row + c);
      int d2Bit = 1 << (row - c + n - 1);

      if ((colMask & cBit) != 0) continue;
      if ((d1Mask & d1Bit) != 0) continue;
      if ((d2Mask & d2Bit) != 0) continue;

      dfs(row + 1, colMask | cBit, d1Mask | d1Bit, d2Mask | d2Bit);
    }

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    dfs(0, 0, 0, 0);

    System.out.println(cnt);
  }

}