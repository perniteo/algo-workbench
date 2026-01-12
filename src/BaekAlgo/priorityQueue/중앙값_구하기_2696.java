package BaekAlgo.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중앙값_구하기_2696 {

  // maxHeap, minHeap 을 동시에 사용
  // maxHeap의 peek()이 중앙값을 보장하는 것을 구현

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

      int m = Integer.parseInt(br.readLine());

      sb.append((m + 1) / 2).append("\n");

      StringTokenizer st = null;

      int printed = 0;
        for (int j = 0; j < m; j++) {
          if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
          }
          int num = Integer.parseInt(st.nextToken());

          if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
          } else {
            minHeap.add(num);
          }

          if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int a = maxHeap.poll();
            int b = minHeap.poll();
            minHeap.add(a);
            maxHeap.add(b);
          }

          if (j % 2 == 0) {
            sb.append(maxHeap.peek()).append(" ");
            printed++;
            if (printed % 10 == 0) sb.append("\n");
          }
        }

        sb.append("\n");

      }

    System.out.println(sb);

  }
}