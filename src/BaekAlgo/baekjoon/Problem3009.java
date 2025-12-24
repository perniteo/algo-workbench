package BaekAlgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3009 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] dot = new int[3][2];

    // xor 연산을 통해 짝수중복 제거

    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      dot[i][0] = Integer.parseInt(st.nextToken());
      dot[i][1] = Integer.parseInt(st.nextToken());
    }
    System.out.println(
        (dot[0][0] ^ dot[1][0] ^ dot[2][0]) + " " + (dot[0][1] ^ dot[1][1] ^ dot[2][1]));

//    Set<Integer> xSet = new HashSet<>();
//    Set<Integer> ySet = new HashSet<>();
//
//    int xSum = 0;
//    int ySum = 0;
//
//    for (int i = 0; i < 3; i++) {
//      StringTokenizer st = new StringTokenizer(br.readLine());
//      int x = Integer.parseInt(st.nextToken());
//      int y = Integer.parseInt(st.nextToken());
//
//      xSet.add(x);
//      xSum += x;
//      ySet.add(y);
//      ySum += y;
//    }
//
//    StringBuilder sb = new StringBuilder();
//    sb.append(xSet.stream().mapToInt(Integer::intValue).sum() * 2 - xSum)
//        .append(" ")
//        .append(ySet.stream().mapToInt(Integer::intValue).sum() * 2 - ySum);
//
//    System.out.println(sb);

  }

}
