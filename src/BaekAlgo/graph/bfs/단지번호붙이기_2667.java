package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class 단지번호붙이기_2667 {

  static int[][] graph;
  static boolean[][] visited;
  static int n;

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};


  public static int bfs(int row, int col) {
     int count = 0;

     visited[row][col] = true;
     count++;

     Queue<int[]> q = new ArrayDeque<>();
     q.offer(new int[]{row, col});

     while (!q.isEmpty()) {
       int[] next = q.poll();
       int r = next[0];
       int c = next[1];

       for (int i = 0; i < 4; i++) {
         int nr = r + dr[i];
         int nc = c + dc[i];

         if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

         if (!visited[nr][nc] && graph[nr][nc] == 1) {
           q.offer(new int[]{nr, nc});
           visited[nr][nc] = true;
           count++;
         }
       }
     }

     return count;
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
          complex.add(bfs(i, j));
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