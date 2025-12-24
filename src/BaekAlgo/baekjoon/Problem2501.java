package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


// 약수 구하기
public class Problem2501 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<Integer> list = new ArrayList<>();

    //기본적인 약수 구하기 형태
    //제곱근 기준으로 +-의 짝을 이룸 < 약수 형태의 기본적 사고
    for (int i = 1; i <= Math.sqrt(N); i++) {
      if (N % i == 0) {
        list.add(i);
        if (i != N / i) {
          list.add(N / i);
        }
      }
    }

    Collections.sort(list);

    if (K > list.size()) {
      System.out.println(0);
    } else {
      System.out.println(list.get(K - 1));
    }

  }
}

