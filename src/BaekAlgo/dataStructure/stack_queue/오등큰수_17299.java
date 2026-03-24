package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 오등큰수_17299 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Map<Integer, Integer> map = new HashMap<>();

    int n = Integer.parseInt(br.readLine());

    int[] answer = new int[n];

    Arrays.fill(answer, -1);

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      arr[i] = num;
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {

      while (!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
        int idx = stack.pop();

        answer[idx] = arr[i];
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();

    for (int a : answer) {
      sb.append(a).append(" ");
    }

    System.out.println(sb);

  }
}
