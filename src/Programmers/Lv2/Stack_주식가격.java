package Programmers.Lv2;

import java.util.*;

class Stack_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            
            while (!dq.isEmpty() && prices[dq.peek()] > prices[i]) {
                int idx = dq.pop();
                answer[idx] = i - idx;
            }
            
            dq.push(i);
        }
        
        while (!dq.isEmpty()) {
            int idx = dq.pop();
            
            answer[idx] = prices.length - idx - 1;
        }
        
        return answer;
    }
}