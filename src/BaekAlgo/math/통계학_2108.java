package BaekAlgo.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 통계학_2108 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    double sum = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    int[] num = new int[n];
    int[] count = new int[8001];

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(br.readLine());

      sum += input;
      max = Math.max(max, input);
      min = Math.min(min, input);
      num[i] = input;
      count[input + 4000]++;
    }

    long avr = Math.round(sum / n);
    int range = max - min;
    Arrays.sort(num);
    int mid = num[n/2];

    int modeCount = 0;
    for (int c : count) {
      modeCount = Math.max(c, modeCount);
    }

    int mode = 0;

    int cnt = 0;
    for (int i = 0; i <= 8000; i++) {
      if (count[i] == modeCount) {
        cnt++;
        mode = i - 4000;
        if (cnt == 2) break;
      }
    }

    System.out.println(avr + "\n" + mid + "\n" + mode + "\n" + range);
  }
}