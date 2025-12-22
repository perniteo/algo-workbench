package BaekAlgo.set.hashSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자_카드_10815 {
  
  // 단순 포함 여부만 검사하는 문제
  // hashSet 에 최적

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Set<Integer> set = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());

      set.add(num);
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (set.contains(num)) {
        bw.write(1 + " ");
      } else {
        bw.write(0 + " ");
      }
    }

    bw.flush();

  }
}