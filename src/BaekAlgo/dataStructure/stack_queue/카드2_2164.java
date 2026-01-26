package BaekAlgo.dataStructure.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2_2164 {

  // queue

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> queue = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n ; i++) {
      queue.offer(i);
    }

    while (queue.size() > 1) {
      queue.poll();

      queue.offer(queue.poll());
    }

    System.out.println(queue.poll());
  }
}