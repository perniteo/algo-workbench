package BaekAlgo.dataStructure.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 도키도키_12789 {

  // stack

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> stack = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int curr = 0;

    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());

      while (!stack.isEmpty() && stack.peek() == curr + 1) {
        stack.pop();
        curr++;
      }

      if (curr + 1 == num) {
        curr++;
      } else {
      stack.push(num);
      }
    }

    while (!stack.isEmpty()) {
      if (stack.pop() == curr + 1) {
        curr++;
      } else {
        break;
      }
    }

    System.out.println(curr == n ? "Nice" : "Sad");
  }
}