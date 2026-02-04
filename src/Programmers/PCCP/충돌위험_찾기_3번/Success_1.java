package Programmers.PCCP.충돌위험_찾기_3번;

import java.util.*;

class Success_1 {

    // route 가 여러 route인 것을 고려했음
    // 현재 방식은 각 robot마다 경로를 다 기억하고, 시점마다 count 하고 있음
    // 따라서 메모리 사용량이 늘어나게 돼서 아쉬움
    // 각 시점마다 robot을 이동하고 비교하면 memory refactoring 효율적일듯
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        List<List<Integer>> list = new ArrayList<>();

        for (int[] route : routes) {
            List<Integer> r = new ArrayList<>();

            r.add(points[route[0] - 1][0] * 1000+ points[route[0] - 1][1]);

            int countRoute = route.length;

            for (int i = 0; i < countRoute - 1; i++) {
                int[] start = points[route[i] - 1];
                int[] end = points[route[i+1] - 1];

                int sRow = start[0];
                int sCol = start[1];
                int eRow = end[0];
                int eCol = end[1];

                while (sRow != eRow) {
                    sRow += (sRow < eRow ? 1 : -1);
                    r.add(sRow * 1000 + sCol);
                }
                while (sCol != eCol) {
                    sCol += (sCol < eCol ? 1 : -1);
                    r.add(sRow * 1000 + sCol);
                }
            }

            list.add(r);

        }

        int idx = 0;
        
        while (true) {
            Map<Integer, Integer> map = new HashMap<>();
            int cnt = 0;
            for (List<Integer> l : list) {
                if (idx < l.size()) {
                    int key = l.get(idx);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    cnt++;
                }
            }
          if (cnt < 2) {
            break;
          }
            
            for (int v : map.values()) {
                if (v >= 2) {
                    answer++;
                }
            }
            idx++;
        }
             
        return answer;
    }
}