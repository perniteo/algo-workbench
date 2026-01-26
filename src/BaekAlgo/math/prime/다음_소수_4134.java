package BaekAlgo.math.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다음_소수_4134 {

  public static boolean isPrime(long n) {
    if (n == 2) {
      return true;
    }

    if (n <= 1 || n % 2 == 0) {
      return false;
    }

    for (long i = 3; i <= n / i; i += 2) {

      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      long n = Long.parseLong(br.readLine());

      while (!isPrime(n)) {
        n++;
      }
      System.out.println(n);
    }

  }
}