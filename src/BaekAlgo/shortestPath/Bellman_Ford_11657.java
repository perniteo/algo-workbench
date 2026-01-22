package BaekAlgo.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bellman_Ford_11657 {

  // 가중치가 음수가 존재할 수 있을 때 사용

  static ArrayList<Edge> edges = new ArrayList<>();

  static int n;

  static long[] dist;

  static final long INF = Long.MAX_VALUE / 4;

  static class Edge {
    int v;
    int u;
    long w;
    Edge(int v, int u, long w) {
      this.v = v;
      this.u = u;
      this.w = w;
    }
  }

  static boolean bellmanFord(int start) {
    dist[start] = 0;

    for (int i = 0; i < n - 1; i++) {
      for (Edge e : edges) {
        if (dist[e.v] == INF) continue;
        if (dist[e.v] + e.w < dist[e.u]) {
          dist[e.u] = dist[e.v] + e.w;
        }
      }
    }

    for (Edge e : edges) {
      if (dist[e.v] == INF) continue;
      if (dist[e.v] + e.w < dist[e.u]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    dist = new long[n+1];
    Arrays.fill(dist, INF);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      edges.add(new Edge(a, b, c));
    }

    StringBuilder sb = new StringBuilder();

    if (!bellmanFord(1)) {
      sb.append(-1);
    } else {
      for (int i = 2; i <= n; i++) {
        long d = dist[i];
        sb.append(d == INF ? -1 : d).append("\n");
      }
    }

    System.out.println(sb);

  }
}
