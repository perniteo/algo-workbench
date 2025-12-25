package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 요세푸스_11866 {

  // 요세푸스를 queue 를 활용하여 푸는 문제
  // refactor-notes/deque-rotation.md 참고

  // 성능상으로는 arrayList 가 더 좋을 것이라 예상됨

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> queue = new ArrayDeque<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= n ; i++) {
      queue.offer(i);
    }

    StringBuilder sb = new StringBuilder();

    int c = 1;

    while (!queue.isEmpty()) {
      for (int i = 0; i < k - 1; i++) {
        queue.offer(queue.poll());
      }
      int eliminated = queue.poll();

      sb.append(eliminated);

      if (!queue.isEmpty()) {
        sb.append(", ");
      }
    }

    System.out.println("<" + sb + ">");
  }
}