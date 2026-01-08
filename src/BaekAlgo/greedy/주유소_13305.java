package BaekAlgo.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    long[] dis = new long[n];

    long cost = 0;

    long minPrice = Integer.MAX_VALUE;

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      dis[i] = Long.parseLong(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      int price = Integer.parseInt(st.nextToken());
      minPrice = Math.min(minPrice, price);

      cost += minPrice * dis[i];
    }

    System.out.println(cost);

  }
}