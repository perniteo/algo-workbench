package Programmers.KAKAO.WINTER_INTERNSHIP2024;

import java.util.*;

class 가장_많이_받은_선물 {
    public int solution(String[] friends, String[] gifts) {
        int f = friends.length;
        
        Map<String, Integer> fIndex = new HashMap<>();
        
        for (int i = 0; i < f; i++) {
            fIndex.put(friends[i], i);
        }
        
        int[][] gift = new int[f][f];
        int[] score = new int[f];
        
        for (String g : gifts) {
            StringTokenizer st = new StringTokenizer(g);
            String a = st.nextToken();
            String b = st.nextToken();
            
            score[fIndex.get(b)]--;
            score[fIndex.get(a)]++;
            gift[fIndex.get(b)][fIndex.get(a)]++;
        }
        
        int[] result = new int[f];
        
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < f; j++) {
              if (i == j) {
                continue;
              }
                int c = gift[i][j] - gift[j][i];
                if (c > 0) {
                    result[j]++;
                } else if (c == 0 && score[j] > score[i]) {
                    result[j]++;
                }
            }
        }
        
        int answer = 0;
        for (int r : result) {
            answer = Math.max(answer, r);
        }
        return answer;
    }
}