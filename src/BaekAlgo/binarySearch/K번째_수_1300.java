package BaekAlgo.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째_수_1300 {

  // 꽤나 어려웠음
  // 단순히 1차원 배열로 만들고 sort() 하기엔 무조건 초과될 것이 뻔했음
  // 이분 탐색으로 해결 가능한 것도 알고 있었지만
  // 문제 자체가 b[k] -> k보다 같거나 작은수가 k개 라는 뜻임
  // 저 아이디어를 바탕으로 count()해서 나오는 수를 k랑 비교
  // 탐색은 binarySearch
  // 구현은 쉽지만 로직이 이해하기 쉽지 않았음

  static long n;
  static long k;

  public static long count(long x) {

    long c = 0;

    for (int i = 1; i <= n; i++) {
      c += Math.min(x / i, n);
    }
    return c;
  }

  public static long binarySearch(long n, long k) {

    long left = 0;

    long right = n * n;

    long answer = 0;

    while (left <= right) {
      long mid = (right - left) / 2 + left;

      if (count(mid) < k) {
        left = mid + 1;
      } else {
        answer = mid;
        right = mid - 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    k = Integer.parseInt(br.readLine());

    System.out.println(binarySearch(n, k));

  }
}