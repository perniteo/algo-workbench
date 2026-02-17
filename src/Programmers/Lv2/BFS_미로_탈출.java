package Programmers.Lv2;

import java.util.*;

class BFS_미로_탈출 {

    // graph bfs, 조건에 맞게 2번 진행
    // 초기화가 귀찮음
    
    char[][] graph;
    
    int[][] dist;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int row;
    int col;
    
    int[] s = new int[2];
    int[] e = new int[2];
    int[] l = new int[2];
    
    int bfs(int[] start, int[] target) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        dist = new int[row][col];
        
        for (int[] d : dist) {
            Arrays.fill(d, -1);
        }
        
        q.offer(start);
        dist[start[0]][start[1]] = 0;
        
        while (!q.isEmpty()) {
            int[] n = q.poll();
            
            int cr = n[0];
            int cc = n[1];
            
            if (cr == target[0] && cc == target[1]) {
                return dist[cr][cc];
            }
            
            int cd = dist[cr][cc];
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

              if (nr < 0 || nc < 0 || nr >= row || nc >= col) {
                continue;
              }
                
                if (dist[nr][nc] == -1 && graph[nr][nc] != 'X') {
                    q.offer(new int[]{nr, nc});
                    dist[nr][nc] = cd + 1;
                }
                
            }
        }
        
        return dist[target[0]][target[1]];
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        row = maps.length;
        
        col = maps[0].length();
        
        graph = new char[row][col];
        
        for (int i = 0; i < row; i++) {
            String str = maps[i];
            
            for (int j = 0; j < col; j++) {
                char c = str.charAt(j);
                graph[i][j] = c;
                
                if (c == 'S') {
                    s[0] = i;
                    s[1] = j;
                } else if (c == 'E') {
                    e[0] = i;
                    e[1] = j;
                } else if (c == 'L') {
                    l[0] = i;
                    l[1] = j;
                }
            }
        }

        int a = bfs(s, l);
        int b = bfs(l, e);
        
        if (a == -1 || b == -1) {
            answer = -1;
        } else {
            answer = a + b;
        }
        
        return answer;
    }
}