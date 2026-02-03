package Programmers.PCCP.충돌위험_찾기_3번;

import java.util.*;

class Fail {

  // route 가 여러개인 것을 고려하지 않고 시도했음
  // 조건을 읽지 않았으니까 아주 바보같은 실수
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int route = routes.length;
        
        int[] curR = new int[route];
        int[] curC = new int[route];
        int[] endR = new int[route];
        int[] endC = new int[route];
        boolean[] arrived = new boolean[route];
        
        for (int i = 0; i < route; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            curR[i] = points[start-1][0];
            curC[i] = points[start-1][1];
            endR[i] = points[end-1][0];
            endC[i] = points[end-1][1];
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < route; i++) {
            int key = curR[i] * 1000 + curC[i];
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
                    
        for (int c : count.values()) {
            if (c >= 2) {
                answer++;
            }
        }
        
        while (true) {
            int arrive = 0;
            count = new HashMap<>();
            
            for (boolean arr : arrived) {
              if (arr) {
                arrive++;
              }
            }
          if (arrive == route) {
            break;
          }
            
            for (int i = 0; i < route; i++) {
                if (!arrived[i]) {
                    if (curR[i] != endR[i]) {
                        curR[i] += (curR[i] < endR[i] ? 1 : -1);
                    } else if (curC[i] != endC[i]) {
                        curC[i] += (curC[i] < endC[i] ? 1 : -1);
                    }    
                    
                }
            }
            for (int i = 0; i < route; i++) {
                if (!arrived[i]) {
                    int key = curR[i] * 1000 + curC[i];
                    count.put(key, count.getOrDefault(key, 0) + 1);
                }

              if (curR[i] == endR[i] && curC[i] == endC[i]) {
                arrived[i] = true;
              }
                
            }
            for (int c : count.values()) {
              if (c >= 2) {
                answer++;
              }
            }
        }
        
        return answer;
    }
}