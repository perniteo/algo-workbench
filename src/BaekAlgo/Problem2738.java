package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2738 {

  public static void addMatrixRow(int[][] matrix, int row, String line) {
    StringTokenizer st = new StringTokenizer(line);
    for (int i = 0; i < matrix[row].length; i++) {
      int num = Integer.parseInt(st.nextToken());
      matrix[row][i] += num;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      addMatrixRow(matrix, i, br.readLine());
    }

    for (int i = 0; i < n; i++) {
      addMatrixRow(matrix, i, br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int x : matrix[i]) {
        sb.append(x).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}

