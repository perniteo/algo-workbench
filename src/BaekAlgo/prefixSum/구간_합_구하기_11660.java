package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_11660 {

  // 2차원 prefix-sum

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int[][] prefixDp = new int[n+1][n+1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int num = Integer.parseInt(st.nextToken());

        prefixDp[i][j] = prefixDp[i-1][j] + prefixDp[i][j-1] - prefixDp[i-1][j-1] + num;
      }
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      sb.append(prefixDp[endX][endY]
          - prefixDp[startX-1][endY]
          - prefixDp[endX][startY-1]
          + prefixDp[startX-1][startY-1]).append('\n');
    }

    System.out.println(sb);

  }
}