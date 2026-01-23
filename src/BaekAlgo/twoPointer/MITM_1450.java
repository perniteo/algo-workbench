package BaekAlgo.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MITM_1450 {

  // MITM 부분 집합 개수를 구하는 것을 서로 정렬 후 two-pointer 로 경우의 수 누적

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] item = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      item[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> sumA = new ArrayList<>();
    ArrayList<Integer> sumB = new ArrayList<>();
    sumA.add(0);
    sumB.add(0);

    for (int i = 0; i < n / 2; i++) {
      int s = sumA.size();
      for (int j = 0; j < s; j++) {
        int nw = sumA.get(j) + item[i];
        if (nw <= c) sumA.add(nw);
      }
    }

    for (int i = n / 2; i < n; i++) {
      int s = sumB.size();
      for (int j = 0; j < s; j++) {
        int nw = sumB.get(j) + item[i];
        if (nw <= c) sumB.add(nw);
      }
    }

    Collections.sort(sumA);
    Collections.sort(sumB);

    long result = 0;

    int l = 0;
    int r = sumB.size() - 1;

    while (l < sumA.size() && r >= 0) {
      long sum = sumA.get(l) + sumB.get(r);
      if (sum <= c) {
        result += (r + 1);
        l++;
      }
      else {
        r--;
      }
    }

    System.out.println(result);
  }
}
