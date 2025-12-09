package BaekAlgo.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 재귀를 활용하려고 한게 문제인듯
// 메모리초과

public class P2798 {

  static int answer = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());

    int N = Integer.parseInt(st.nextToken());

    int[] arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    CombinationBacktracking(arr, 3, 0, new ArrayList<>(), N);

    System.out.println(answer);
  }

  static void CombinationBacktracking(int[] arr, int r, int start,
      List<Integer> chosen, int N) {

    if (chosen.size() == r) {

      int sum = chosen.stream().mapToInt(Integer::intValue).sum();
      if (sum <= N) {
        answer = Math.max(answer, chosen.stream().mapToInt(Integer::intValue).sum());
        return;
      }
    }

    for (int i = start; i < arr.length; i++) {
      chosen.add(arr[i]);
      CombinationBacktracking(arr, r, i + 1, chosen, N);
      chosen.remove(chosen.size() - 1);
    }
  }
}