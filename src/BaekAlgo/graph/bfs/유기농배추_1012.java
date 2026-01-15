package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

  static boolean[][] graph;
  static boolean[][] visited;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};

  static int m;
  static int n;

  static class Node {
    int r;
    int c;
    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public static void bfs(int r, int c) {
    Queue<Node> q = new ArrayDeque<>();

    q.offer(new Node(r, c));

    visited[r][c] = true;

    while (!q.isEmpty()) {
      Node next = q.poll();

      for (int i = 0; i < 4; i++) {
        int nr = next.r + dr[i];
        int nc = next.c + dc[i];

        if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

        if (!visited[nr][nc] && graph[nr][nc]) {
          q.offer(new Node(nr, nc));
          visited[nr][nc] = true;
        }
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
            bfs(r, c);
            count++;
          }
        }
      }

      sb.append(count).append("\n");

    }

    System.out.println(sb);
  }
}