package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class queueStack_24511 {

  // 나름 재밌다고 생각했던 문제
  // stack 에서는 들어갔던 원소가 나오고(변화 없음) --> FIFO
  // queue 에서는 원래 있는 원소가 밀려나옴        --> LIFO

  // 결과적으로는 queue 끼리만 교체가 일어나는데,
  // 이 말은 곧 queue 끼리만 모아놓은 구조에서 선입후출 하는 것

  // 마지막 결론을 맺지 못해서 queue index 에서만 교체 해야하나? 했는데
  // n * m 으로 절대 불가능 할 것이라고 생각..

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> dq = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());

    StringTokenizer queueStack = new StringTokenizer(br.readLine());
    StringTokenizer value = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int qs = Integer.parseInt(queueStack.nextToken());
      int v = Integer.parseInt(value.nextToken());

      if (qs == 0) {
        dq.push(v);
      }
    }

    int m = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      int ele = Integer.parseInt(st.nextToken());

      dq.offer(ele);

      sb.append(dq.poll()).append(" ");
    }

    System.out.println(sb);
  }
}