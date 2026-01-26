package BaekAlgo.dataStructure.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로_다른_부분_문자열_개수_11478 {

  // subString 활용

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();

    Set<String> set = new HashSet<>();

    int curr = 1;

    while (curr <= S.length()) {
      for (int i = 0; i <= S.length() - curr; i++) {
        set.add(S.substring(i, i+curr));
      }
      curr++;
    }

    System.out.println(set.size());
  }
}