package BaekAlgo.dataStructure.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기_2346 {

  // gpt 5.2 와 싸워서 이긴 코드
  // deque 연습하면서 deque 로 구현하는 문제에
  // 통과가 되는 코드임에도 arrayList의 index를 사용하는 게 맞다고 우김
  // 정확히는 deque 에도 index를 쓸 수 있는 것 처럼 함

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> dq = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] papers = new int[n+1];

    for (int i = 1; i <= n ; i++) {
      dq.offer(i);
      papers[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();

    while (true) {

      int number = dq.poll();

      if (dq.isEmpty()) {
        sb.append(number);
        break;
      }

      sb.append(number).append(" ");

      int move = papers[number];

      if (move > 0) {
        for (int i = 0; i < move - 1; i++) {
          dq.offer(dq.poll());
        }
      } else {
        for (int i = 0; i > move; i--) {
          dq.push(dq.pollLast());
        }
      }
    }

    System.out.println(sb);
  }
}