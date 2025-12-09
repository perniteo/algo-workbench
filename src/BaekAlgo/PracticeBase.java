package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PracticeBase {

  public static int tenBaseInt(String num, int base) {
    // result 공식을 최대한 직관적으로 이해할 것, 높은 자리수 부터 표현
    int result = 0;

    for (int i = 0; i < num.length(); i++) {
      char c = num.charAt(i);

      int value = Character.isDigit(c) ? c - '0' : c - 'A' + 10;

      result = result * base + value;
    }

    return result;
  }

  public static String fromToDecimal(int num, int base) {
    // 1자리수 부터 변환, sb에 누적하기 때문에 마지막에 reverse

    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      int remainder = num % base;

      char digit;

      if (remainder < 10) {
        digit = (char) ('0' + remainder);
      } else {
        digit = (char) ('A' + remainder - 10);
      }

      sb.append(digit);
      num /= base;
    }

    return sb.reverse().toString();
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int num = Integer.parseInt(st.nextToken());

    int base = Integer.parseInt(st.nextToken());

    System.out.println(fromToDecimal(num, base));
  }
}

