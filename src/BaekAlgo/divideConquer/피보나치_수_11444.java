package BaekAlgo.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수_11444 {

  // 피보나치 수를 행렬곱을 이용해서 계산
  // 거듭제곱을 반으로 나누고 계산하는 log n의 분할/정복

  static final long MOD = 1_000_000_007;

  static long[][] mul(long[][] A, long[][] B) {
    long[][] C = new long[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        long sum = 0;
        for (int k = 0; k < 2; k++) {
          sum = (sum + A[i][k] * B[k][j]) % MOD;
        }
        C[i][j] = sum;
      }
    }
    return C;
  }

  static long[][] pow(long[][] M, long n) {
    if (n == 1) return M;
    long[][] half = pow(M, n / 2);
    long[][] res = mul(half, half);
    if (n % 2 == 1) res = mul(res, M);
    return res;
  }

  public static long fib(long n) {

    if (n == 0) return 0;
    if (n == 1) return 1;

    long[][] M = {
        {1, 1},
        {1, 0}
    };

    long[][] R = pow(M, n - 1);


    return R[0][0];
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());

    System.out.println(fib(n));

  }
}