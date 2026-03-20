package BaekAlgo.Impl;

import java.io.*;
import java.util.*;

public class 치킨_배달_15686 {

  static ArrayList<int[]> houses = new ArrayList<>();

  static int result = Integer.MAX_VALUE;

  static void count(ArrayList<int[]> select) {
    int total = 0;
    for (int[] house : houses) {
      int minDist = Integer.MAX_VALUE;
      for (int[] chicken : select) {
        minDist = Math.min(minDist, Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]));
      }
      total += minDist;
    }
    result = Math.min(result, total);
  }

  static void selectChicken(ArrayList<int[]> chicken, int m, int idx, ArrayList<int[]> select) {
    if (select.size() == m) {
      count(select);
      return;
    }
    if (idx == chicken.size()) {
      return;
    }

    int size = chicken.size();

    for (int i = idx; i < size; i++) {
      select.add(chicken.get(i));
      selectChicken(chicken, m, i + 1, select);
      select.remove(chicken.get(i));
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st =  new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<int[]> chicken = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        int info = Integer.parseInt(st.nextToken());

        if (info == 1) {
          houses.add(new int[]{i, j});
        } else if (info == 2) {
          chicken.add(new int[]{i, j});
        }
      }
    }

    selectChicken(chicken, m, 0, new ArrayList<>());

    System.out.println(result);
  }
}
