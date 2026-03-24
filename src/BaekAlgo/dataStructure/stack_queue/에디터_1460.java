package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 에디터_1460 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayDeque<String> left = new ArrayDeque<>();
    ArrayDeque<String> right = new ArrayDeque<>();

    String str = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      left.push(String.valueOf(str.charAt(i)));
    }

    int m = Integer.parseInt(br.readLine());

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String command = st.nextToken();

      if (command.equals("L") && !left.isEmpty()) {
        right.push(left.pop());
      } else if (command.equals("D") && !right.isEmpty()) {
        left.push(right.pop());
      } else if (command.equals("B") && !left.isEmpty()) {
        left.pop();
      } else if (command.equals("P")) {
        String push = st.nextToken();
        left.push(push);
      }
    }

    StringBuilder sb = new StringBuilder();

    int lSize = left.size();
    int rSize = right.size();

    for (int i = 0; i < lSize; i++) {
      sb.append(left.pollLast());
    }
    for (int i = 0; i < rSize; i++) {
      sb.append(right.pop());
    }

    System.out.println(sb);

  }
}
