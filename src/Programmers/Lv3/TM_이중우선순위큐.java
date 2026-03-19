package Programmers.Lv3;

import java.util.*;

class TM_이중우선순위큐 {

    // tree-map

    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for (String operation : operations) {
            String[] oper = operation.split(" ");
            
            String op = oper[0];
            int num = Integer.parseInt(oper[1]);
            
            if (op.equals("I")) {
                tm.put(num, tm.getOrDefault(num, 0) + 1);
            } else if (op.equals("D")) {
              if (tm.isEmpty()) {
                continue;
              }
                if (num == -1) {
                    int minKey = tm.firstKey();
                    if (tm.get(minKey) == 1) {
                        tm.remove(minKey);
                    } else {
                        tm.put(minKey, tm.get(minKey) - 1);
                    }
                } else {
                    int maxKey = tm.lastKey();
                    if (tm.get(maxKey) == 1) {
                        tm.remove(maxKey);
                    } else {
                        tm.put(maxKey, tm.get(maxKey) - 1);
                    }
                }
            }
        }
        
        if (tm.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{tm.lastKey(), tm.firstKey()};
        }
        
        return answer;
    }
}