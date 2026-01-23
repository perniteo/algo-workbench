package BaekAlgo.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MITM_1450 {

  // MITM 부분 집합의 개수 결과를 구하는데 binary-search를 통해 누적

  static ArrayList<Integer> sumB;

  static int c;

  static int binarySearch(int a) {
    int left = 0;
    int right = sumB.size();

    while (left < right) {
      int mid = (right - left) / 2 + left;

      if (a + sumB.get(mid) <= c) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    int[] item = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      item[i] = Integer.parseInt(st.nextToken());
    }

    ArrayList<Integer> sumA = new ArrayList<>();
    sumB = new ArrayList<>();
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

    Collections.sort(sumB);

    int result = 0;

    for (int a : sumA) {
      result += binarySearch(a);
    }

    System.out.println(result);
  }
}
