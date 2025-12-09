package BaekAlgo;

import java.util.Scanner;

public class Problem2839 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int answer = 0;

    while (N > 0) {

      if (N % 5 == 0) {
        answer += N / 5;
        N %= 5;
        break;
      }
      N -= 3;
      answer += 1;
    }
    if (N != 0) {
      System.out.println("-1");
    } else {
      System.out.println(answer);
    }

  }
}
