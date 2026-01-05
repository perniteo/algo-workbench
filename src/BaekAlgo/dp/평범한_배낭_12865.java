package BaekAlgo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭_12865 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    int[] dp = new int[k+1];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      for (int j = k; j >= w; j--) {
        dp[j] = Math.max(dp[j-w] + v, dp[j]);
      }
    }

    System.out.println(dp[k]);
  }
}