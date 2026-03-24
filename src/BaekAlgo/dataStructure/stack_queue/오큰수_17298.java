package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 오큰수_17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    int[] answer = new int[n];

    Arrays.fill(answer, -1);

    for (int i = 0; i < n; i++) {

      while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
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
