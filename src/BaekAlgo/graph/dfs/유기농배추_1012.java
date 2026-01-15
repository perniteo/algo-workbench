package BaekAlgo.graph.dfs;

import java.io.*;
import java.util.*;

public class 유기농배추_1012 {

  static boolean[][] graph;
  static boolean[][] visited;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int m;
  static int n;

  public static void dfs(int r, int c) {
    visited[r][c] = true;

    for (int i = 0; i < 4; i++) {
      int nr = r + dr[i];
      int nc = c + dc[i];

      if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

      if (graph[nr][nc] && !visited[nr][nc]) {
        dfs(nr, nc);
      }
    }

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());

      int k = Integer.parseInt(st.nextToken());

      graph = new boolean[m][n];
      visited = new boolean[m][n];

      int count = 0;

      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        graph[row][col] = true;
      }

      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          if (graph[r][c] && !visited[r][c]) {
            dfs(r, c);
            count++;
          }
        }
      }

      sb.append(count).append("\n");

    }

    System.out.println(sb);
  }
}