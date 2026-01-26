package BaekAlgo.dataStructure.hashSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 포켓몬_1620 {

  // value(object), id(idx) 동시 조회
  // 효율에 대해 고민 list, map 을 같이 사용

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();

    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String pokemon = br.readLine();

      map.put(pokemon, i + 1);

      list.add(pokemon);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < m; i++) {
      String input = br.readLine();

      if (input.chars().allMatch(Character::isDigit)) {
        bw.write(list.get(Integer.parseInt(input) - 1) + "\n");
      } else {
        bw.write(map.get(input) + "\n");
      }
    }

    bw.flush();

  }
}