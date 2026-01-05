package BaekAlgo.dp.전깃줄_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class lis_binarysearch_nlogn {

  static List<Integer> lis = new ArrayList<>();

  static int binarySearch(int target) {
    int left = 0;
    int right = lis.size() - 1;

    while (left < right) {
      int mid = (right - left) / 2 + left;

      if (lis.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][2];

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[i][0] = a;
      arr[i][1] = b;
    }

    Arrays.sort(arr, (a, b) -> a[0] - b[0]);

    lis.add(arr[0][1]);

    for (int i = 1; i < n; i++) {

      int target = arr[i][1];

      if (target > lis.get(lis.size() - 1)) {
        lis.add(target);
      } else {
        lis.set(binarySearch(target), target);
      }
    }

    System.out.println(n - lis.size());

  }
}