package BaekAlgo.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

  // 문제 요구에 맞게 3차원으로 확장만 하였음
  // level 상태를 따로 day로 사용하고 있기 때문에
  // graph를 int가 아닌 short로 바꾸는 것이 메모리에서 조금이나마 효율적일 듯함
  // 또한 3차원 배열을 1차원 배열로 평탄화하여 배열 객체 헤더 메모리를 줄일 수 있을듯

  static int[][][] graph;

  static Queue<int[]> q = new ArrayDeque<>();

  static int[] dr = {-1, 1, 0, 0, 0, 0};
  static int[] dc = {0, 0, -1, 1, 0, 0};
  static int[] dh = {0, 0, 0, 0, 1, -1};

  static int m;
  static int n;
  static int h;

  static int unRipe = 0;

  static int day = 0;

  public static void bfs() {
    while (!q.isEmpty()) {
      int s = q.size();

      for (int i = 0; i < s; i++) {
        int[] next = q.poll();

        for (int j = 0; j < 6; j++) {
          int nr = next[0] + dr[j];
          int nc = next[1] + dc[j];
          int nh = next[2] + dh[j];
          if (nr < 0 || nc < 0 || nr >= n || nc >= m || nh < 0 || nh >= h) continue;

          if (graph[nr][nc][nh] == 0) {
            graph[nr][nc][nh] = 1;
            q.offer(new int[]{nr, nc, nh});
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

    h = Integer.parseInt(st.nextToken());

    graph = new int[n][m][h];
    for (int k = 0; k < h; k++) {
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          int tomato = Integer.parseInt(st.nextToken());
          graph[i][j][k] = tomato;
          if (tomato == 1) q.offer(new int[]{i, j, k});
          if (tomato == 0) unRipe++;
        }
      }
    }

    bfs();

    System.out.println(unRipe == 0 ? day - 1 : -1);

  }
}