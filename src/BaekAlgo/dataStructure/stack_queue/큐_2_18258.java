package BaekAlgo.dataStructure.stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐_2_18258 {

  // 동일하게 deque 를 사용하지만 stack 과는 확실히 다른 것을 느낌
  // java deque 에 대해 정확히 알아야 할 필요있음

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> queue = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String command = st.nextToken();

      switch (command) {
        case "push": {
          queue.offer(Integer.parseInt(st.nextToken()));
          break;
        }
        case "pop": {
          bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
          break;
        }
        case "size": {
          bw.write(queue.size() + "\n");
          break;
        }
        case "empty": {
          bw.write((queue.isEmpty() ? 1 : 0) + "\n");
          break;
        }
        case "front": {
          bw.write((queue.isEmpty() ? -1 : queue.peekFirst()) + "\n");
          break;
        }
        case "back": {
          bw.write((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
          break;
        }
      }
    }

    bw.flush();
  }
}