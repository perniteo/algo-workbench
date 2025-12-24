package BaekAlgo.gcd.lcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// refactoring 필요
public class 분수_합_1735 {

  // Fraction class 사용해서 분수형태의 객체만 사용하려고 했음
  // 근데 연산은 따로 값만 꺼내서 하다보니까 난잡
  // fraction class 에 연산을 넣는 것이 깔끔할 듯
  // 또한 약분을 계속 해주어야 하는 것을 생각

  public static class Fraction {
    long num;
    long den;

    Fraction (long num, long den) {
      this.num = num;
      this.den = den;
    }
  }

  public static long gcd(long a, long b) {
    long r;

    while (b != 0) {
      r = a % b;
      a = b;
      b = r;
    }

    return a;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    List<Fraction> list = new ArrayList<>();

    for (int i = 0; i < 2; i++) {
      st = new StringTokenizer(br.readLine());
      long num = Long.parseLong(st.nextToken());
      long den = Long.parseLong(st.nextToken());

      long g = gcd(num, den);

      list.add(new Fraction(num / g, den / g));
    }

    long num1 = list.get(0).num;
    long num2 = list.get(1).num;

    long den1 = list.get(0).den;
    long den2 = list.get(1).den;

    long den = den1 * den2 / gcd(den1, den2);
    long num = den / den1 * num1 + den / den2 * num2;

    long gcd = gcd(den, num);

    System.out.println(num / gcd + " " + den / gcd);

  }
}