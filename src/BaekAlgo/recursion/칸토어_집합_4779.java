
package BaekAlgo.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 칸토어_집합_4779 {

  public static void recursion(char[] chars, int start, int len) {

    if (len <= 1) {
      return;
    }

    int third = len / 3;

    recursion(chars, start, third);
    for (int i = start + third; i < start + third * 2; i++) {
      chars[i] = ' ';
    }
    recursion(chars, start + third * 2, third);

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line;

    while ((line = br.readLine()) != null) {
      int n = Integer.parseInt(line);

      char[] arr = new char[(int) Math.pow(3, n)];

      Arrays.fill(arr, '-');

      recursion(arr, 0, arr.length);

      System.out.println(new String(arr));
    }
  }
}