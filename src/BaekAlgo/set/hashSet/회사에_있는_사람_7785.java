package BaekAlgo.set.hashSet;

import java.io.*;
import java.util.*;

public class 회사에_있는_사람_7785 {

  // hashSet

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Set<String> set = new HashSet<>();

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();

      String commute = st.nextToken();

      if (commute.equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }

    List<String> list = new ArrayList<>(set);

    list.sort(Comparator.reverseOrder());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (String name : list) {
      bw.write(name + "\n");
    }

    bw.flush();
  }
}
