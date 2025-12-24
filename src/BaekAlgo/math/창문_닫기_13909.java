package BaekAlgo.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 창문_닫기_13909 {

  // 1 ~ n 까지의 범위에서 각 수의 배수마다 창문을 열거나 닫음
  // 그 수의 약수 개수가 홀수면 결과적으로 열림
  // ** 약수의 개수가 홀수라는 경우는 제곱수 밖에 없음
  // 이 말은 곧 n 까지의 제곱수의 개수를 찾는 것
  // n의 제곱근의 정수부분 --> 답

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    System.out.println((int) Math.sqrt(n));
  }
}