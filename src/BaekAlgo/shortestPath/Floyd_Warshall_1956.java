package BaekAlgo.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd_Warshall_1956 {

  // floyd 를 활용해 구한 dist graph 에서 최단 경로 cycle 구하기
  // 간단하게 응용 가능

  static final long INF = Long.MAX_VALUE / 4;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    long[][] dist = new long[v+1][v+1];

    for (long[] d : dist) {
      Arrays.fill(d, INF);
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      dist[a][b] = Math.min(dist[a][b], c);
    }

    for (int k = 1; k <= v; k++) {
      for (int i = 1; i <= v; i++) {
        if (dist[i][k] == INF) continue;
        for (int j = 1; j <= v; j++) {
          if (dist[k][j] == INF) continue;
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    long result = INF;

    for (int i = 1; i <= v; i++) {
      for (int j = 1; j <= v; j++) {
        if (i == j) continue;
        result = Math.min(result, dist[i][j] + dist[j][i]);
      }
    }

    System.out.println(result == INF ? -1 : result);
  }
}
