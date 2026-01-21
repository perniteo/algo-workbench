package BaekAlgo.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd_Warshall_11404 {

  // 모든 출발지를 구해야 할때 효과적

  // 간선 수가 중복 간선도 많거나 Dense Graph 일수록 효과적

  static final long INF = Long.MAX_VALUE / 4;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int m = Integer.parseInt(br.readLine());

    long[][] dist = new long[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      Arrays.fill(dist[i], INF);
    }

    StringTokenizer st;

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      dist[a][b] = Math.min(dist[a][b], c);
    }

    for (int i = 1; i <= n; i++) { // 경유
      for (int j = 1; j <= n; j++) { // 출발
        if (i == j) dist[i][j] = 0;
        if (dist[j][i] == INF) continue; // 경유지 못 가면 패스
        for (int k = 1; k <= n; k++) { // 도착
          dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
        }
      }
    }


    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        sb.append(dist[i][j] >= INF ? "0" : dist[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
