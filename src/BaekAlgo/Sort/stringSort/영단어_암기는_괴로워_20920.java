package BaekAlgo.Sort.stringSort;

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

public class 영단어_암기는_괴로워_20920 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String word = br.readLine();

      if (word.length() >= m) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
    }

    List<String> words = new ArrayList<>(map.keySet());

    words.sort((a, b) -> {
      if (map.get(a) != map.get(b)) {
        return map.get(b) - map.get(a);
      }
      if (a.length() != b.length()) {
        return b.length() - a.length();
      }
      return a.compareTo(b);
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (String word : words) {
      bw.write(word + "\n");
    }

    bw.flush();
  }
}