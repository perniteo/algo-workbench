package Programmers.코드챌린지_2025;

import java.util.*;

class 비밀_코드_해독_1차예선 {
    
    static Set<Integer> pick = new HashSet<>();
    
    static int answer = 0;
    
    static int[][] q;
    static int n;
    static int[] ans;
    
    static int count = 0;
    
    static void dfs(int index) {
        if (pick.size() == 5) {
            count++;
            for (int j = 0; j < q.length; j++) {
                int c = 0;
                for (int k : q[j]) {
                  if (pick.contains(k)) {
                    c++;
                  }
                }
              if (c != ans[j]) {
                return;
              }
            }
            answer++;
            return;
        }
        
        for (int i = index; i <= n; i++) {
            pick.add(i);
            dfs(i + 1);
            pick.remove(i);
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.n = n;
        this.ans = ans;
        
        dfs(1);
        
        return answer;
    }
}