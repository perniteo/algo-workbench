package Programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑 {

  // twoPointers 를 이용하여 풀었음 리팩토링 요소가 남아있어서 살짝 아쉬움
  
  // 기본적으로 2개의 인덱스를 다루며 조건에 맞게 탐색, 범위조정하는 메커니즘을 기억할 것

  int[] twoPointer(String[] list, Set<String> target) {
    int[] result = new int[2];

    Map<String, Integer> counter = new HashMap<>();
    int required = target.size();
    int left = 0;

    int right = 0;

    int current = 0;

    int minLen = Integer.MAX_VALUE;

    for (int i = 0; i < list.length; i++) {
      right = i;
      String gem = list[i];

      counter.put(gem, counter.getOrDefault(gem, 0) + 1);

      if (target.contains(gem) && counter.get(gem) == 1) {
        current++;
      }

      while (current == required && left <= right) {

        if (right - left < minLen) {
          result[0] = left;
          result[1] = right;
          minLen = Math.min(minLen, right - left);
        }

        String g = list[left];
        counter.put(g, counter.get(g) - 1);
        left++;

        if (counter.get(g) == 0 && target.contains(g)) {
          current--;
        }

      }
    }

    result[0]++;
    result[1]++;

    return result;
  }


  public int[] solution(String[] gems) {
    Set<String> set = new HashSet<>(List.of(gems));

    return twoPointer(gems, set);
  }
}