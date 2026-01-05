package BaekAlgo.dp.ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 위상정렬_1005 {

  // degree 조건에 부합한 것만 그 순서에 맞게 처리했음

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      List<List<Integer>> graph = new ArrayList<>(n+1);

      for (int a = 0; a <= n; a++) {
        graph.add(new ArrayList<>());
      }
      int[] cost = new int[n + 1];
      int[] dp = new int[n + 1];
      int[] degree = new int[n + 1];

      st = new StringTokenizer(br.readLine());

      for (int a = 1; a <= n; a++) {
        cost[a] = Integer.parseInt(st.nextToken());
      }

      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        graph.get(x).add(y);

        degree[y]++;
      }

      int target = Integer.parseInt(br.readLine());

      Queue<Integer> q = new ArrayDeque<>();

      for (int a = 1; a <= n; a++) {
        if (degree[a] == 0) {
          dp[a] = cost[a];
          q.add(a);
        }
      }

      while (!q.isEmpty()) {
        int cur = q.poll();

        for (int next : graph.get(cur)) {
          dp[next] = Math.max(dp[cur] + cost[next], dp[next]);
          degree[next]--;

          if (degree[next] == 0) {
            q.add(next);
          }
        }
      }

      sb.append(dp[target]).append('\n');

    }
    System.out.println(sb);
  }
}