package BaekAlgo.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인간컴퓨터_상호작용_16139 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();

    int q = Integer.parseInt(br.readLine());

    int[][] pSum = new int[S.length()+1][26];

    for (int i = 0; i < S.length(); i++) {
      for (int j = 0; j < 26; j++) {
        pSum[i + 1][j] = pSum[i][j];
      }
      pSum[i + 1][S.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char target = st.nextToken().charAt(0);
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      sb.append(pSum[y+1][target - 'a'] - pSum[x][target - 'a']).append('\n');
    }

    System.out.println(sb);
  }
}