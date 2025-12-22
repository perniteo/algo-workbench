package BaekAlgo.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좌표_압축_18870 {

  public static void merge(int[] arr, int[] left, int[] right) {

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    while (i < left.length) {
      arr[k++] = left[i++];
    }
    while (j < right.length) {
      arr[k++] = right[j++];
    }

  }

  public static void mergeSort(int[] arr) {

    if (arr.length < 2) {
      return;
    }

    int mid = arr.length / 2;

    int[] left = new int[mid];

    int[] right = new int[arr.length - mid];

    for (int i = 0; i < mid; i++) {
      left[i] = arr[i];
    }
    for (int i = mid; i < arr.length; i++) {
      right[i - mid] = arr[i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(arr, left, right);

  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      arr[i] = num;
    }

    int[] sorted = arr.clone();

    Arrays.sort(sorted);

    Map<Integer, Integer> map = new HashMap<>();

    int idx = 0;

    for (int i = 0; i < n; i++) {
      if (i == 0 || sorted[i] != sorted[i - 1]) {
        map.put(sorted[i], idx++);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int num : arr) {
      bw.write(map.get(num) + " ");
    }

    bw.flush();
  }
}