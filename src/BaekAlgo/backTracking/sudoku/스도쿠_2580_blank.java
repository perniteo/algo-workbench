package BaekAlgo.backTracking.sudoku;
import java.io.*;
import java.util.*;

public class 스도쿠_2580_blank {

  // 전체 탐색 -> blank(0) 탐색

    static int[][] board = new int[9][9];

    static List<int[]> blank;

  public static boolean isValid(int r, int c, int num) {

    for (int i = 0; i < 9; i++) {
      if (board[r][i] == num || board[i][c] == num) {
        return false;
      }
    }
    int row3x3 = r / 3 * 3;
    int col3x3 = c / 3 * 3;

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

    int[] b = blank.get(idx);
    int r = b[0];
    int c = b[1];

    for (int num = 1; num <= 9; num++) {
      if (isValid(r, c, num)) {
        board[r][c] = num;
        if (dfs(idx + 1)) return true;
        board[r][c] = 0;
      }
    }


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
        if (num == 0) {
          blank.add(new int[]{i, j});
        }
        board[i][j] = num;
      }
    }

    dfs(0);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j]).append(' ');
      }
      sb.append('\n');
    }

    System.out.println(sb);
  }
}

