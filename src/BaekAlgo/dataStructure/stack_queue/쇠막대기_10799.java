package BaekAlgo.dataStructure.stack_queue;

import java.io.*;
import java.util.*;

public class 쇠막대기_10799 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayDeque<Character> stack = new ArrayDeque<>();

    String input = br.readLine();

    int answer = 0;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (c == '(') {
        stack.push(c);
      } else {
        stack.pop();
        if (input.charAt(i - 1) == '(') {
          answer += stack.size();
        } else {
          answer++;
        }
      }

    }

    System.out.println(answer);


  }
}
