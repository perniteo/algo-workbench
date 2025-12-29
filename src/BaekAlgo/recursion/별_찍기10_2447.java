package BaekAlgo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별_찍기10_2447 {

  // 2차원

  public static void remove(char[][] arr, int row, int col, int len) {
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        arr[i+row][j+col] = ' ';
      }
    }
  }

  public static void recursion(char[][] arr, int row, int col, int len) {

    if (len == 1) {
      return;
    }

    int third = len / 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          remove(arr, row + i * third, col + j * third, third);
        } else {
          recursion(arr, row + i * third, col + j * third, third);
        }
      }
    }

  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    char[][] arr = new char[n][n];

    for (char[] chars : arr) {
      Arrays.fill(chars, '*');
    }

    recursion(arr, 0, 0, n);

    StringBuilder sb = new StringBuilder();

    for (char[] chars : arr) {
      for (char c : chars) {
        sb.append(c);
      }
      sb.append("\n");
    }

    System.out.println(sb);

  };
}