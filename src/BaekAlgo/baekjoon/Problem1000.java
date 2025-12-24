package BaekAlgo.baekjoon;

import java.util.Scanner;

public class Problem1000 {

  public static void main(String[] args) {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    String[] input = br.readLine().split(" ");

    Scanner sc = new Scanner(System.in);

    int answer = 0;

//    while (sc.hasNextInt()) {
//      answer += sc.nextInt();
//    }
    for (int i = 0; i < 2; i++) {
      answer += sc.nextInt();
    }

    System.out.println(answer);

    sc.close();
  }

}
