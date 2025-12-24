package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2581 {
  //에라토스테네스의 체를 활용한 구간 소수 구하기 최적화

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int start = Integer.parseInt(br.readLine());
    int end = Integer.parseInt(br.readLine());

    boolean[] isPrime = new boolean[end + 1];

    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    int sqrt = (int) Math.sqrt(end);

    for (int i = 2; i <= sqrt; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= end; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int sumPrime = 0;
    int minPrime = Integer.MAX_VALUE;

    for (int i = start; i <= end; i++) {
      if (isPrime[i]) {
        sumPrime += i;
        minPrime = Math.min(minPrime, i);
      }
    }

    if (sumPrime == 0) {
      System.out.println(-1);
    } else {
      System.out.println(sumPrime);
      System.out.println(minPrime);
    }
  }
}


