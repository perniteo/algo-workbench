package Programmers.Lv2;

import java.util.*;

class Sort_가장_큰_수 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

      if (arr[0].equals("0")) {
        return "0";
      }
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : arr) {
            sb.append(str);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}