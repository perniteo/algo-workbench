package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2559 {

  // sliding window, two pointer 가능

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    int[] prefix = new int[n + 1];

    st = new StringTokenizer(br.readLine());

    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += Integer.parseInt(st.nextToken());
      prefix[i] = sum;
    }

    int maxSum = Integer.MIN_VALUE;

    for (int i = k; i <= n; i++) {
      maxSum = Math.max(prefix[i] - prefix[i - k], maxSum);
    }

    System.out.println(maxSum);

  }
}