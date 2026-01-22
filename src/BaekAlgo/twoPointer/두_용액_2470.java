package BaekAlgo.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_용액_2470 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] list = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(list);

    int res1 = 0;
    int res2 = 0;

    long bestSum = Long.MAX_VALUE;

    int i = 0;
    int j = n-1;

    while (i < j) {
      int cur = list[i] + list[j];

      if (bestSum > Math.abs(cur)) {
        res1 = list[i];
        res2 = list[j];
        bestSum = Math.abs(cur);
      }

      if (cur == 0) break;
      if (cur < 0) i++;
      if (cur > 0) j--;
    }

    System.out.println(res1 + " " + res2);

  }
}
