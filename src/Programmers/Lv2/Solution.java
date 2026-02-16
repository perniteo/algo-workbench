package Programmers.Lv2;

import java.util.*;

class Solution {

  // count overflow 주의

    public long solution(int[] weights) {
        long answer = 0;

        long[] count = new long[1001];
        
        Set<Integer> set = new HashSet<>();
        
        for (int weight : weights) {
            set.add(weight);
            count[weight]++;
        }
        
        for (int s : set) {
          if (count[s] > 1) {
            answer += (count[s] * (count[s] - 1)) / 2;
          }
          if (s % 2 == 0 &&
              s + (s / 2) <= 1000 && count[s + (s / 2)] > 0) {
            answer += count[s] * count[s + (s / 2)];
          }
          if (s * 2 <= 1000 && count[s * 2] > 0) {
            answer += count[s] * count[s * 2];
          }
          if (s % 3 == 0 &&
              s + (s / 3) <= 1000 && count[s + (s / 3)] > 0) {
            answer += count[s] * count[s + (s / 3)];
          }
        }
        
        return answer;
    }
}