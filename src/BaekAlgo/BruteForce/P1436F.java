package BaekAlgo.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class P1436F {
  // 영화감독 숀
  // 처음 생각한 정규식 엔진 666 matches 사용 검사
  // String 객체 생성은 메모리 초과가 안 된다고 생각함
  // 정규식 엔진 사용이 메모리를 많이 사용한다는 걸 알게 됨

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = 0;
    int curr = 665;

    int n = Integer.parseInt(br.readLine());

    while (count != n) {
      curr++;
      if (String.valueOf(curr).matches(".*666.*")) {
        count++;
      }
    }

    System.out.println(curr);
  }
}