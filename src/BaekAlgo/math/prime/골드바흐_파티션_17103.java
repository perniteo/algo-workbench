package BaekAlgo.math.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 골드바흐_파티션_17103 {

  // 에라토스테네스의 체 + 투 포인터

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0;

    List<Integer> list = new ArrayList<>();

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());

      max = Math.max(n, max);

      list.add(n);
    }

    boolean[] prime = new boolean[max+1];

    Arrays.fill(prime, true);

    prime[0] = prime[1] = false;

    for (int i = 2; i <= Math.sqrt(max); i++) {
      for (int j = i * i; j <= max; j += i) {
        prime[j] = false;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int n : list) {
      int count = 0;
      int left = 3;
      int right = n - 3;

      if (n == 4) {
        sb.append(1).append("\n");
        continue;
      }

      while (left <= right) {
        if (prime[left] && prime[right]) count++;
        left += 2;
        right -= 2;
      }
      sb.append(count).append("\n");
    }

    System.out.println(sb);

  }
}