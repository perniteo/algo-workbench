package Programmers.Lv2;

import java.util.*;

class heap_더_맵게 {
    // pq(최소 힙)

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();     
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        
        
        return answer;
    }
}