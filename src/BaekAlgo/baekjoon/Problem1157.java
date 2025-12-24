package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem1157 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<Character, Integer> hashMap = new HashMap<>();

    String str = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      char target = Character.toUpperCase(str.charAt(i));
      hashMap.merge(target, 1, Integer::sum);
    }

    int maxValue = Collections.max(hashMap.values());

    ArrayList<Character> list = new ArrayList<>();

    for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
      if (entry.getValue() == maxValue) {
        list.add(entry.getKey());
      }
    }
    System.out.println(list.size() > 1 ? "?" : list.get(0));
  }
}
