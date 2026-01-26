package BaekAlgo.math.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 베르트랑_공준_4948 {
  
  // 에라토스테네스의 체

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0;

    List<Integer> list = new ArrayList<>();

    while (true) {
      int n = Integer.parseInt(br.readLine());

      if (n == 0) break;

      max = Math.max(max, n);

      list.add(n);
    }

    max *= 2;

    boolean[] prime = new boolean[max + 1];

    Arrays.fill(prime, true);

    prime[0] = false;
    prime[1] = false;

    for (int i = 2; i <= Math.sqrt(max); i++) {
      for (int j = i * i; j <= max; j += i) {
        prime[j] = false;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int num : list) {
      int c = 0;
      for (int i = num + 1; i <= num * 2; i++) {
        if (prime[i]) c++;
      }
      sb.append(c).append("\n");
    }

    System.out.println(sb);

  }
}