package BaekAlgo.set.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 문자열_집합_14425 {

  // 대상이 문자열이다.

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    int count = 0;

    for (int i = 0; i < m; i++) {
      if (set.contains(br.readLine())) {
        count++;
      }
    }
    
    System.out.println(count);

  }
}