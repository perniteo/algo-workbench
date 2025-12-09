package BaekAlgo.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비효율적인 배열 사용과 Stream 사용을 없애고
// 각 조건에 맞게 return 하며 누적합 방식으로 바꿔서 개선했음

public class P2798N1 {

  static int answer = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());

    int N = Integer.parseInt(st.nextToken());

    int[] arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    CombinationBacktracking(arr, 3, 0, 0, 0, N);

    System.out.println(answer);
  }

  static void CombinationBacktracking(int[] arr, int r, int start,
      int chosenCount, int sum, int N) {

    if (chosenCount == r) {
      if (sum <= N) {
        answer = Math.max(answer, sum);
      }
      return;
    }

    for (int i = start; i < arr.length; i++) {
      CombinationBacktracking(arr, r, i + 1, chosenCount + 1, sum + arr[i], N);
    }
  }
}