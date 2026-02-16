package Programmers.Lv2;

import java.util.*;

class BF_전력망을_둘로_나누기 {

    // 완전탐색 + bfs
    // graph 가정 하에 bfs 여러 번 했음
    // 문제는 tree 성질 이용해서 bfs 한 번 구하고 남은 길이로 계산 단축 가능
    
    ArrayList<ArrayList<Integer>>list = new ArrayList<>();
    
    boolean[] visited;
    
    int bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        int count = 0;
        
        q.offer(start);
        visited[start] = true;
        count++;
        
        while (!q.isEmpty()) {
            int num = q.poll();

            for (int next : list.get(num)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        for (int[] wire : wires) {
            ArrayList<Integer> lens = new ArrayList<>(); 
            visited = new boolean[n + 1];
            int v1 = wire[0];
            int v2 = wire[1];
            
            list.get(v1).remove(Integer.valueOf(v2));
            list.get(v2).remove(Integer.valueOf(v1));
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    lens.add(bfs(i));
                }
            }
            list.get(v1).add(v2);
            list.get(v2).add(v1);
            
            if (lens.size() > 1) {
                answer = Math.min(Math.abs(lens.get(0) - lens.get(1)), answer);
            }
        }
        
        return answer;
    }
}