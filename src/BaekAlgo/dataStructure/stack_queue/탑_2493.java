package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 탑_2493 {

  // 왼큰수
  // for문에서 idx를 정방향으로도 가능

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] tower = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      tower[i] = Integer.parseInt(st.nextToken());
    }

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    int[] result = new int[n];

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && tower[stack.peek()] < tower[i]) {
        int idx = stack.pop();
        result[idx] = i + 1;
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();

    for (int r : result) {
      sb.append(r).append(" ");
    }

    System.out.println(sb);
  }
}
