package BaekAlgo.backTracking.sudoku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 스도쿠_2580_mrv {

  // 가장 적은 경우의 수를 먼저 처리함
  // MRV (Minimum Remaining Values)
  // 근데 뭔가 이 문제에서는 오히려 성능이 떨어졌음..
  // bitmask 추가 검토중

  static int[][] board = new int[9][9];

  static List<int[]> blank;

  public static boolean isValid(int row, int col, int num) {

    for (int n : board[row]) {
      if (n == num) {
        return false;
      }
    }
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num) {
        return false;
      }
    }

    int row3x3 = (row / 3) * 3;
    int col3x3 = (col / 3) * 3;

    for (int i = row3x3; i < row3x3 + 3; i++) {
      for (int j = col3x3; j < col3x3 + 3; j++) {
        if (board[i][j] == num) {
          return false;
        }
      }
    }

    return true;
  }

  public static boolean dfs(int idx) {
    if (idx == blank.size()) {
      return true;
    }

    int bestIdx = -1;
    int minCnt = 10;

    for (int i = idx; i < blank.size(); i++) {
      int r = blank.get(i)[0];
      int c = blank.get(i)[1];

      if (board[r][c] != 0) {
        continue;
      }

      int cnt = 0;

      for (int num = 1; num <= 9; num++) {
        if (isValid(r, c, num)) {
          cnt++;
        }
      }
      if (cnt == 0) {
        return false;
      }

      if (cnt < minCnt) {
        minCnt = cnt;
        bestIdx = i;
      }
    }
    Collections.swap(blank, idx, bestIdx);

    int[] target = blank.get(idx);
    int r = target[0];
    int c = target[1];

    for (int num = 1; num <= 9; num++) {
      if (isValid(r, c, num)) {
        board[r][c] = num;
        if (dfs(idx + 1)) return true;
        board[r][c] = 0;
      }
    }

    Collections.swap(blank, idx, bestIdx);

    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    blank = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int num = Integer.parseInt(st.nextToken());
        board[i][j] = num;
        if (num == 0) {
          blank.add(new int[]{i, j});
        }
      }
    }

    dfs(0);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      for (int n : board[i]) {
        sb.append(n).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  };
}