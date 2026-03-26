package Programmers.Lv1;

import java.util.*;

class Sort_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
            int[] command = commands[c];
            int start = command[0] - 1;
            int end = command[1] - 1;
            
            int[] arr = new int[end - start + 1];
            
            for (int i = start; i <= end; i++) {
                arr[i-start] = array[i];
            }
            
            Arrays.sort(arr);
            
            answer[c] = arr[command[2] - 1];
        }
        
        return answer;
    }
}