package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

  public class 뉴스_전하기_1135 {

    // 인접 노드, dfs를 활용한 greedy에 가까운듯

    static ArrayList<ArrayList<Integer>> adj;

    static int dfs(int cur) {
      ArrayList<Integer> times = new ArrayList<>();

      for (int child : adj.get(cur)) {
        times.add(dfs(child));
      }

      if (times.isEmpty()) return 0;

      Collections.sort(times, (a, b) -> {
        return b - a;
      });

      int maxTime = 0;

      for (int i = 0; i < times.size(); i++) {
        maxTime = Math.max(maxTime, times.get(i) + (i + 1));
      }

      return maxTime;
    }

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      adj = new ArrayList<>();

      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
      }

      for (int i = 0; i < n; i++) {
        int parent = Integer.parseInt(st.nextToken());

        if (parent != -1) {
          adj.get(parent).add(i);
        }
      }

      System.out.println(dfs(0));
    }
  }
