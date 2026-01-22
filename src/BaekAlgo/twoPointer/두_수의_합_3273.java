package BaekAlgo.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두_수의_합_3273 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] list = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(list);

    int x = Integer.parseInt(br.readLine());

    int i = 0;
    int j = n-1;

    int count = 0;

    while (i < j) {
      int sum = list[i] + list[j];
      if (sum == x) {
        count++;
        i++;
        j--;
      } else if (sum > x) {
        j--;
      } else {
        i++;
      }
    }

    System.out.println(count);

  }
}
