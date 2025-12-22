package BaekAlgo.Sort.stringSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소트인사이드_1427 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] count = new int[10];

    String str = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);

      count[c - '0']++;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 9; i >= 0; i--) {
      for (int j = 0; j < count[i]; j++) {
        sb.append(i);
      }
    }

    System.out.println(sb);
  }
}