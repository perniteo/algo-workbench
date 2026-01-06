package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지_합_10986 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(st.nextToken());

    int cur = 0;

    long answer = 0;

    long[] remains = new long[m];

    remains[0] = 1;

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      cur = (cur + num) % m;

      remains[cur]++;
    }

    for (int i = 0; i < m; i++) {
      answer += remains[i] * (remains[i] - 1) / 2;
    }

    System.out.println(answer);
  }
}