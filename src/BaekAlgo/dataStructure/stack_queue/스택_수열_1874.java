package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 스택_수열_1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    StringBuilder sb = new StringBuilder();

    int num = 1;

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());

      while (num <= input) {
        stack.push(num++);
        sb.append("+").append("\n");
      }

      if (input == stack.peek()) {
        stack.pop();
        sb.append("-").append("\n");
      } else {
        System.out.println("NO");
        return;
      }
    }
    System.out.println(sb);
  }
}
