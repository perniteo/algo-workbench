package Programmers.Lv2;

import java.util.*;

class BFS_게임_맵_최단거리 {
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int n;
    static int m;
    
    static int[][] dist;
    
    static void bfs(int r, int c, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{r, c});
        dist[r][c] = 1;
        
        while(!q.isEmpty()) {
            int[] next = q.poll();
            int cr = next[0];
            int cc = next[1];

          if (cr == n - 1 && cc == m - 1) {
            return;
          }
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

              if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
              }
                
                if (dist[nr][nc] == -1 && maps[nr][nc] == 1) {
                    q.offer(new int[]{nr, nc});
                    dist[nr][nc] = dist[cr][cc] + 1;
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        dist = new int[n][m];
        
        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }
        
        bfs(0, 0, maps);
        
        return dist[n-1][m-1];
    }
}