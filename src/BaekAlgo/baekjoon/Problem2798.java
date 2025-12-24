package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2798 {

  // 브루트포스를 이용
  // 단 3개의 조합만 유효하기 때문에 가능한듯함
  //

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer = 0;

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] cards = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 1; j < N - 1; j++) {
        for (int k = j + 1; k < N; k++) {
          int sum = cards[i] + cards[j] + cards[k];
          if (sum <= M) {
            answer = Math.max(answer, cards[i] + cards[j] + cards[k]);
          }
        }
      }
    }

    System.out.println(answer);
  }
}