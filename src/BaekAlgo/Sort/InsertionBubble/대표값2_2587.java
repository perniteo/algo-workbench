package BaekAlgo.Sort.InsertionBubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대표값2_2587 {

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];

      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = key;
    }
  }

  public static void bubbleSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j+1]) {
          int impl = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = impl;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr = new int[5];

    for (int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    bubbleSort(arr);

    int sum = 0;

    for (int n : arr) {
      sum+=n;
    }
    System.out.printf("%d\n%d", sum/5, arr[2]);
  }
}