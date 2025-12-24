package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2720 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] money = new int[]{25, 10, 5, 1};

    StringBuilder sb = new StringBuilder();

    int c = Integer.parseInt(br.readLine());

    for (int i = 0; i < c; i++) {
      int change = Integer.parseInt(br.readLine());
      for (int m : money) {
        int coin = change / m;
        sb.append(coin).append(" ");
        change -= m * coin;
      }
      sb.append("\n");
    }

    System.out.println(sb.toString().trim());
  }
}

