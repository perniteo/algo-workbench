package BaekAlgo.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수_1037 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer factors = new StringTokenizer(br.readLine());

    int max = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int factor = Integer.parseInt(factors.nextToken());

      max = Math.max(factor, max);
      min = Math.min(factor, min);
    }

    System.out.println(max * min);
  }
}