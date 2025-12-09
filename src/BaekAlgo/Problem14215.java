package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem14215 {
  // 세 막대
  // 삼각형 조건 검사, 줄여서 만들기

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] line = new int[3];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 3; i++) {
      line[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(line);

    if (line[0] + line[1] > line[2]) {
      System.out.println(line[0] + line[1] + line[2]);
    } else {
      System.out.println((line[0] + line[1]) * 2 - 1);
    }
  }
}