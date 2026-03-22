package Programmers.KAKAO.인턴십2020;

import java.util.*;

class BFS_경주로_건설 {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int[][][] cost;
    
    int n;
    
    class Node {
        int r;
        int c;
        int dir;  // 0-상 1-하 2-좌 3-우 들어온 방향
        Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    
    void bfs(int[][] board, int r, int c) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.offer(new Node(0, 0, 1));
        q.offer(new Node(0, 0, 3));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || board[nr][nc] == 1) {
                    continue;
                }
                int nextCost = cost[cur.r][cur.c][cur.dir];
                
                if (cur.dir == i) {
                    nextCost += 100;
                } else {
                    nextCost += 600;
                }
                if (nextCost <= cost[nr][nc][i]) {
                    cost[nr][nc][i] = nextCost;
                    q.offer(new Node(nr, nc, i));
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        n = board.length;
        
        cost = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                  if (i == 0 && j == 0) {
                    continue;
                  }
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(board, 0, 0);
        
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[n-1][n-1][i]);
        }
        
        return answer;
    }
}