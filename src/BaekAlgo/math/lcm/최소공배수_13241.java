package BaekAlgo.math.lcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수_13241 {

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

    st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    System.out.println(a * b /gcd(a, b));

  }
}