package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Problem1316 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int words = Integer.parseInt(br.readLine());

    int answer = 0;

    for (int i = 0; i < words; i++) {
      HashSet<Character> checkSet = new HashSet<>();
      // 문제에서는 알파벳 소문자만을 주기 때문에 boolean[26]으로 check 만 하는 것도 좋음
      String str = br.readLine();

      boolean group = true;

      checkSet.add(str.charAt(0));

      for (int j = 1; j < str.length(); j++) {
        char prev = str.charAt(j - 1);
        char curr = str.charAt(j);
        if (checkSet.contains(curr)) {
          if (prev != curr) {
            group = false;
            break;
          }
        } else {
          checkSet.add(str.charAt(j));
        }
        System.out.println(checkSet);
      }
      if (group) {
        answer++;
      }

    }

    System.out.println(answer);
  }
}

