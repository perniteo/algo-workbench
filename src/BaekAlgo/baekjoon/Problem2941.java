package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2941 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String croatia3 = "dz=";
    String[] croatia2 = new String[]{"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    // HashSet 사용하고 contains 메소드를 사용하여 검사 가능

    // String 배열 순회하면서 주어진 문자열에
    // replace 메소드를 적용해서 최종적으로 변환된 String 의 길이로 검사 가능
    // 크로아티아 문자(2~3길이)도 똑같이 1개의 문자로 인식하기 때문

    String str = br.readLine();

    int index = 0;
    int answer = 0;

    while (index < str.length()) {
      boolean matched = false;
      if (str.length() - index > 2 && str.substring(index, index + 3).equals(croatia3)) {
        index += 3;
        answer++;
      } else if (str.length() - index > 1) {
        for (String croatia : croatia2) {
          if (croatia.equals(str.substring(index, index + 2))) {
            index += 2;
            answer++;
            matched = true;
            break;
          }
        }
        if (!matched) {
          index++;
          answer++;
        }
      } else {
        index++;
        answer++;
      }
    }

    System.out.println(answer);
  }
}

