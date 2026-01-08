package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실_배정_1931 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] meeting = new int[n][2];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      meeting[i][0] = Integer.parseInt(st.nextToken());
      meeting[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meeting, (a, b) -> {
      if (a[1] == b[1]) return a[0] - b[0];
      return a[1] - b[1];
    });

    int cur = 0;

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (meeting[i][0] >= cur) {
        cur = meeting[i][1];
        count++;
      }
    }

    System.out.println(count);
  }
}