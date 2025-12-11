package BaekAlgo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P1436F2 {
  // 영화감독 숀
  // 정규식 사용을 Pattern 에 추가하여 최적화 시도했음
  // 결과는 실패 정규식 엔진을 사용하는 것 자체가 무거운 듯함

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;
    int curr = 665;

    int n = Integer.parseInt(br.readLine());

    Pattern p = Pattern.compile(".*666.*");

    while (count != n) {
      curr++;
      if (p.matcher(String.valueOf(curr)).matches()) {
        count++;
      }
    }

    System.out.println(curr);
  }
}