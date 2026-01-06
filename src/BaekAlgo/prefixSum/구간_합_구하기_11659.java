package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_11659 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int[] prefix = new int[n + 1];

    st = new StringTokenizer(br.readLine());

    int sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += Integer.parseInt(st.nextToken());
      prefix[i] = sum;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      sb.append(prefix[y] - prefix[x-1]).append('\n');
    }

    System.out.println(sb);
  }
}