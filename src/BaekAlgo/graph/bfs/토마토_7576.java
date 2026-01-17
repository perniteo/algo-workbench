package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

  static int[][] graph;

  static Queue<int[]> q = new ArrayDeque<>();

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int m;
  static int n;

  static int unRipe = 0;

  static int day = 0;

  public static void bfs() {
    while (!q.isEmpty()) {
      int s = q.size();

      for (int i = 0; i < s; i++) {
        int[] next = q.poll();

        for (int j = 0; j < 4; j++) {
          int nr = next[0] + dr[j];
          int nc = next[1] + dc[j];
          if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

          if (graph[nr][nc] == 0) {
            graph[nr][nc] = 1;
            q.offer(new int[]{nr, nc});
            unRipe--;
          }
        }
      }
      day++;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());

    n = Integer.parseInt(st.nextToken());

    graph = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int tomato = Integer.parseInt(st.nextToken());
        graph[i][j] = tomato;
        if (tomato == 1) q.offer(new int[]{i, j});
        if (tomato == 0) unRipe++;
      }
    }

    bfs();

    System.out.println(unRipe == 0 ? day - 1 : -1);

  }
}