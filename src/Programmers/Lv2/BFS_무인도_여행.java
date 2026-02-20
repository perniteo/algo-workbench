package Programmers.Lv2;

import java.util.*;

class BFS_무인도_여행 {

  // 구역 나누고 구역합 구하기
    
    int[][] map;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int x, y;
    
    int bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        int sum = 0;
        
        q.offer(new int[]{r, c});
        sum += map[r][c];
        map[r][c] = -1;
        
        while (!q.isEmpty()) {
            int[] n = q.poll();
            
            int cr = n[0];
            int cc = n[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

              if (nr < 0 || nc < 0 || nr >= x || nc >= y) {
                continue;
              }
                
                if (map[nr][nc] != -1) {
                    q.offer(new int[]{nr, nc});
                    sum += map[nr][nc];
                    map[nr][nc] = -1;
                }
            }
        }
        
        return sum;
        
    }
    
    public int[] solution(String[] maps) {
        int[] answer;
        
        x = maps.length;
        y = maps[0].length();
        
        map = new int[x][y];
        
        for (int[] m : map) {
            Arrays.fill(m, -1);
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char c = maps[i].charAt(j);
                if (c != 'X') {
                    map[i][j] = Integer.valueOf(c) - '0';
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] != -1) {
                    list.add(bfs(i, j));
                }
            }
        }

      if (list.size() == 0) {
        return new int[]{-1};
      } else {
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
          answer[i] = list.get(i);
        }
      }
        Arrays.sort(answer);
        
        return answer;
    }
}