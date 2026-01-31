package Programmers.코드챌린지_2025;

import java.util.*;

class 완전범죄_2차예선 {

    // 평범한 knapsack dp
    // 이전 상태 -> 현재 상태로 전이하는 방식 (1차원 dp로 축소 가능)
    // 항상 가중치같은 조건에 greedy를 생각해서 머리가 복잡해지고
    // 모든 상태를 생각하려고 해서 dp 구현에 어려움을 겪음
    // dp에 익숙해지고, 그 상태 표현을 믿고 전이에 집중하는 것이 좋을 듯함

    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        
        int len = info.length;
        
        int[][] dp = new int[len+1][m];
        for (int i = 1; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for (int i = 1; i <= len; i++) {
            int[] cost = info[i-1];
            int a = cost[0];
            int b = cost[1];
            
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                if (j + b < m) {
                    dp[i][j+b] = Math.min(dp[i-1][j], dp[i][j+b]);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[len][i]);
        }
        
        return answer < n ? answer : -1;
    }
}