
package BaekAlgo.set.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 붙임성_좋은_총총이_26069 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Set<String> dance = new HashSet<>();
    dance.add("ChongChong");

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String aName = st.nextToken();

      String bName = st.nextToken();

      if (dance.contains(aName) || dance.contains(bName)) {
        dance.add(aName);
        dance.add(bName);
      }
    }

    System.out.println(dance.size());
  }
}