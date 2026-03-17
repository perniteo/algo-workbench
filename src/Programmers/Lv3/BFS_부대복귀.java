package Programmers.Lv3;

import java.util.*;

class BFS_부대복귀 {

    // 역방향 BFS

    List<List<Integer>> graph = new ArrayList<>();
    int[] dist;
    
    void bfs(int dest) {        
        dist[dest] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(dest);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        dist = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        Arrays.fill(dist, -1);
     
        bfs(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}