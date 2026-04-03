package BaekAlgo.dp;

import java.io.*;
  import java.util.*;

  public class 앱_7579 {

    // knapsack(뒤에서 시작 중복 x)

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int[] dp = new int[10001];

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[] memories  = new int[n];
      int[] costs = new int[n];

      st = new StringTokenizer(br.readLine());
      StringTokenizer st2 = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        memories[i] = Integer.parseInt(st.nextToken());
        costs[i] = Integer.parseInt(st2.nextToken());
      }

      for (int i = 0; i < n; i++) {
        int memory = memories[i];
        int cost = costs[i];

        for (int j = 10000; j >= cost; j--) {
          dp[j] = Math.max(dp[j - cost] + memory, dp[j]);
        }
      }

      for (int i = 0; i <= 10000; i++) {
        if (dp[i] >= m) {
          System.out.println(i);
          break;
        }
      }
    }
  }
