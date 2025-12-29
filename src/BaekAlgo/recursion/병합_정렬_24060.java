
package BaekAlgo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 병합_정렬_24060 {

  static int K;          // 찾을 k번째 저장
  static int count = 0;  // 저장 횟수 카운트
  static int answer = -1;

  static int[] A;
  static int[] tmp;

  static void mergeSort(int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      mergeSort(p, q);
      mergeSort(q + 1, r);
      merge(p, q, r);
    }
  }

  static void merge(int p, int q, int r) {
    int i = p;
    int j = q + 1;
    int t = 0;

    while (i <= q && j <= r) {
      if (A[i] <= A[j]) tmp[t++] = A[i++];
      else tmp[t++] = A[j++];
    }
    while (i <= q) tmp[t++] = A[i++];
    while (j <= r) tmp[t++] = A[j++];

    i = p;
    t = 0;
    while (i <= r) {
      A[i] = tmp[t++];
      count++;
      if (count == K) {
        answer = A[i];
        return; // 더 볼 필요 없음
      }
      i++;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    A = new int[N];
    tmp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(0, N - 1);
    System.out.println(answer);
  }
}