package BaekAlgo.stack_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱2_28279 {

  // 덱 == deque 라고 한다.
  // 덱 자료구조 개념에 대해 제대로 이해했나? 검사

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Deque<Integer> dq = new ArrayDeque<>();

    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int command = Integer.parseInt(st.nextToken());

      switch (command) {
        case 1: {
          dq.push(Integer.parseInt(st.nextToken()));
          break;
        }
        case 2: {
          dq.offer(Integer.parseInt(st.nextToken()));
          break;
        }
        case 3: {
          bw.write((dq.isEmpty() ? -1 : dq.pop()) + "\n");
          break;
        }
        case 4: {
          bw.write((dq.isEmpty() ? -1 : dq.pollLast()) + "\n");
          break;
        }
        case 5: {
          bw.write(dq.size() + "\n");
          break;
        }
        case 6: {
          bw.write((dq.isEmpty() ? 1 : 0) + "\n");
          break;
        }
        case 7: {
          bw.write((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
          break;
        }
        case 8: {
          bw.write((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
          break;
        }
      }
    }

    bw.flush();

  }
}