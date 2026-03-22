package Programmers.KAKAO.BLIND2022;

import java.util.*;

class DFS_양궁대회 {

    // 이진 DFS
    
    ArrayList<Integer> hit = new ArrayList<>();
    
    ArrayList<Integer> result = new ArrayList<>();
    
    int maxDiff = Integer.MIN_VALUE;
    
    boolean isBetter(ArrayList<Integer> hit, ArrayList<Integer> result) {
        for (int i = 10; i >= 0; i--) {
          if (hit.get(i) > result.get(i)) {
            return true;
          }
          if (hit.get(i) < result.get(i)) {
            return false;
          }
        }
        return false;
    }
    
    void dfs(int n, int[] info, int idx, int ryan, int apeach) {
        if (idx == info.length) {
            if (n > 0) {
                hit.set(10, n);
            }
            
            int diff = ryan - apeach;
            
            if (diff > maxDiff) {
                maxDiff = Math.max(diff, maxDiff);
                result = new ArrayList<>(hit);
            } else if (diff == maxDiff) {
                if (isBetter(hit, result)) {
                    result = new ArrayList<>(hit);
                }
            }
            
            hit.set(10, 0);
            return;
        }
        

        if (n > info[idx]) {
            hit.set(idx, info[idx] + 1);
            dfs(n - (info[idx] + 1), info, idx + 1, ryan + 10 - idx, apeach);
            hit.set(idx, 0);
        }
        
        int apeachPoint = info[idx] > 0 ? apeach + 10 - idx : apeach;
        
        dfs(n, info, idx + 1, ryan, apeachPoint);
        
    }
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        for (int i = 0; i <= 10; i++) {
            hit.add(0);
            result.add(0);
        }
        
        dfs(n, info, 0, 0, 0);
        
        if (maxDiff <= 0) {
            return new int[]{-1};
        } else {
            answer = new int[info.length];
            for (int i = 0; i < info.length; i++) {
                answer[i] = result.get(i);
            }
        }
        
        return answer;
    }
}