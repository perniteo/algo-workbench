package BaekAlgo.gcd.lcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가로수_2485 {

  // lens, sum 을 한 번의 반복문에서 처리하여 해를 구할 수 있음
  // refactoring 여지 O

  public static long gcd(long a, long b) {
    long r;

    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }

    return a;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] trees = new int[n];
    int[] lens = new int[n - 1];

    trees[0] = Integer.parseInt(br.readLine());

    long sum = 0;

    for (int i = 1; i < n; i++) {
      int t = Integer.parseInt(br.readLine());

      trees[i] = t;

      int dis = trees[i] - trees[i - 1];
      lens[i - 1] = dis;
      sum += dis;
    }

    long gcd = lens[0];

    for (int i = 1; i < n - 1; i++) {
      gcd = gcd(gcd, lens[i]);
    }

    System.out.println((sum - gcd * (n - 1)) / gcd);

  }
}