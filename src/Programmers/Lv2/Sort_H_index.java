package Programmers.Lv2;

import java.util.*;

class Sort_H_index {
    public int solution(int[] citations) {
        int answer = 0;
        
        int size = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < size; i++) {
            if (size - i <= citations[i]) {
                return size - i;
            }
        }
    
        return answer;
    }
}