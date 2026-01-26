package BaekAlgo.dataStructure.hashSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 듣보잡_1764 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    Set<String> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<String> list = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      String name = br.readLine();
      if (set.contains(name)) {
        list.add(name);
      }
    }

    Collections.sort(list);

    bw.write(list.size() + "\n");

    for (String name : list) {
      bw.write(name + "\n");
    }

    bw.flush();
  }
}