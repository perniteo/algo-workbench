package BaekAlgo.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기_2667 {

  static int[][] graph;
  static boolean[][] visited;
  static int n;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int count = 0;

  public static void dfs(int row, int col) {
    visited[row][col] = true;
    count++;

    for (int i = 0; i < 4; i++) {
      int nr = row + dr[i];
      int nc = col + dc[i];

      if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

      if (!visited[nr][nc] && graph[nr][nc] == 1) {
        dfs(nr, nc);
      }
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        if (str.charAt(j) == '1') {
          graph[i][j] = 1;
        }
      }
    }

    ArrayList<Integer> complex = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1 && !visited[i][j]) {
          count = 0;
          dfs(i, j);
          complex.add(count);
        }
      }
    }

    Collections.sort(complex);

    StringBuilder sb = new StringBuilder();

    sb.append(complex.size()).append("\n");

    for (Integer c : complex) {
      sb.append(c).append("\n");
    }

    System.out.println(sb);
  }
}