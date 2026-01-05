package BaekAlgo.dp.ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sort_fail {

  // y를 하기 위한 x들의 선행이 필요하다
  // 그냥 단순 sort 로 될까? 생각해보고 구현
  // 역시나 놓치는 case 존재 했음
  // 위상 정렬이라는 개념을 적용 필요

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] dp = new int[n + 1];
      int rule = Integer.parseInt(st.nextToken());
      int[][] rules = new int[rule][2];
      int[] cost = new int[n];

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        cost[j] = Integer.parseInt(st.nextToken());
      }
      for (int k = 0; k < rule; k++) {
        st = new StringTokenizer(br.readLine());
        rules[k][0] = Integer.parseInt(st.nextToken());
        rules[k][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(rules, (a, b) -> {
        if (a[1] == b[1]) {
          return a[0] - b[0];
        }
        return a[1] - b[1];
      });

      for (int a = 0; a < rule; a++) {
        int build = rules[a][0];
        int target = rules[a][1];

        dp[target] = Math.max(dp[build] + cost[build - 1], dp[target]);
      }

      int w = Integer.parseInt(br.readLine());

      System.out.println(dp[w] + cost[w-1]);

    }

  }
}