package BaekAlgo.backTracking.sudoku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠_2580 {

  static int[][] board = new int[9][9];

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

  public static boolean dfs() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) {
          for (int k = 1; k <= 9; k++) {
            if (isValid(i, j, k)) {
              board[i][j] = k;
              if (dfs()) return true;
              board[i][j] = 0;
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int num = Integer.parseInt(st.nextToken());
        board[i][j] = num;
      }
    }

    dfs();

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