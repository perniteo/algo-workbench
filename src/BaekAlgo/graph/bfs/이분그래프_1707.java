package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이분그래프_1707 {

  static ArrayList<ArrayList<Integer>> graph;

  static boolean[] visited;

  static boolean[] color;

  static boolean bfs(int u) {
    Queue<Integer> q = new ArrayDeque<>();

    q.offer(u);
    visited[u] = true;
    color[u] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int v : graph.get(cur)) {
        if (!visited[v]) {
          visited[v] = true;
          color[v] = !color[cur];
          q.offer(v);
        } else {
          if (color[v] == color[cur])
            return false;
        }
      }
    }

    return true;
  }


  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < k; i++) {
      boolean isBipartite = true;

      graph = new ArrayList<>();

      StringTokenizer st = new StringTokenizer(br.readLine());

      int v = Integer.parseInt(st.nextToken());

      int e = Integer.parseInt(st.nextToken());

      visited = new boolean[v+1];
      color = new boolean[v+1];

      for (int j = 0; j <= v; j++) {
        graph.add(new ArrayList<>());
      }

      for (int j = 0; j < e; j++) {
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        graph.get(start).add(end);
        graph.get(end).add(start);
      }

      for (int j = 1; j <= v; j++) {
        if (!visited[j]) {
          if (!bfs(j)) {
            isBipartite = false;
            break;
          }
        }
      }


      sb.append(isBipartite ? "YES" : "NO").append("\n");
    }

    System.out.println(sb);

  }
}
