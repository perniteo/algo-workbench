package BaekAlgo.lis.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class lis_12015 {

  // 가장 긴 증가하는 부분 수열2
  // 이분 탐색(lower case)을 활용
  // tails 배열 길이가 곧 답 (크기가 최대 원소 개수를 보장)

  static List<Integer> tails;

  public static int binarySearch(int x) {

    int idx = 0;

    int left = 0;

    int right = tails.size() - 1;

    while (left <= right) {
      int mid = (right - left) / 2 + left;

      if (tails.get(mid) < x) {
        left = mid + 1;
      } else {
        idx = mid;
        right = mid - 1;
      }
    }

    return idx;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int a = Integer.parseInt(br.readLine());

    int[] arr = new int[a];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < a; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    tails = new ArrayList<>();

    tails.add(arr[0]);

    for (int i = 1; i < a; i++) {
      int tailLen = tails.size();

      int end = tails.get(tailLen - 1);

      if (arr[i] > end) {
        tails.add(arr[i]);
      } else {
        tails.set(binarySearch(arr[i]), arr[i]);
      }
    }

    System.out.println(tails.size());
  }
}