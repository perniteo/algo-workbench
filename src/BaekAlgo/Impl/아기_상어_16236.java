package BaekAlgo.Impl;

import java.io.*;
  import java.util.*;

  public class 아기_상어_16236 {

    static class Fish {
      int r;
      int c;
      int dist;
      Fish(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
      }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int n;

    static int[][] graph;

    static Fish bfs(int r, int c, int size) {

      PriorityQueue<Fish> pq = new PriorityQueue<>((a, b) -> {
        if (a.dist == b.dist && a.r == b.r) {
          return a.c - b.c;
        }
        if (a.dist == b.dist) {
          return a.r - b.r;
        }
        return a.dist - b.dist;
      }
      );

      boolean[][] visited = new boolean[n][n];

      ArrayDeque<Fish> q = new ArrayDeque<>();
      q.offer(new Fish(r, c, 0));
      visited[r][c] = true;

      while (!q.isEmpty()) {
        Fish f = q.poll();

        for (int i = 0; i < 4; i++) {
          int nr = f.r + dr[i];
          int nc = f.c + dc[i];

          if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc] || graph[nr][nc] > size) {
            continue;
          }

          if (graph[nr][nc] == 0 || graph[nr][nc] == size) {
            visited[nr][nc] = true;
            q.offer(new Fish(nr, nc, f.dist + 1));
          } else if (graph[nr][nc] < size) {
            visited[nr][nc] = true;
            pq.offer(new Fish(nr, nc, f.dist + 1));
            q.offer(new Fish(nr, nc, f.dist + 1));
          }
        }
      }

      return pq.peek();
    }

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(br.readLine());

      graph = new int[n][n];

      int babyR = 0;
      int babyC = 0;

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          int size = Integer.parseInt(st.nextToken());

          if (size == 9) {
            babyR = i;
            babyC = j;
            graph[i][j] = 0;
          } else {
            graph[i][j] = size;
          }
        }
      }

      int babySize = 2;
      int eat = 0;

      int move = 0;

      while (true) {
        Fish fish = bfs(babyR, babyC, babySize);

        if (fish == null) {
          break;
        }

        move += fish.dist;
        eat++;
        if (eat == babySize) {
          babySize++;
          eat = 0;
        }

        graph[fish.r][fish.c] = 0;
        babyR = fish.r;
        babyC = fish.c;
      }

      System.out.println(move);

    }
  }
