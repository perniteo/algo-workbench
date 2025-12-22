package BaekAlgo.Sort.coordinate.좌표_정렬하기_11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class solve1 {

  // 논리는 맞고 통과도 됐음
  // 근데 뭔가 낭비되는 자원이 많고 난잡한 느낌이 듬
  // refactoring 필요

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i <= 200000; i++) {
      lists.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      List<Integer> list = lists.get(x + 100000);

      list.add(y);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i <= 200000; i++) {
      List<Integer> list = lists.get(i);
      if (!list.isEmpty()) {
        Collections.sort(list);
      }
      for (int num : list) {
        bw.write(i - 100000 + " " + num + "\n");
      }
    }
    bw.flush();
  }
}