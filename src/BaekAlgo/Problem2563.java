package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2563 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[][] exist = new boolean[100][100];

    int sheets = Integer.parseInt(br.readLine());

    int answer = 0;

    for (int i = 0; i < sheets; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      for (int row = a; row < a + 10; row++) {
        for (int col = b; col < b + 10; col++) {
          if (!exist[row][col]) {
            exist[row][col] = true;
            answer++;
          }
        }
      }
    }
    System.out.println(answer);

  }
}

