package BaekAlgo.Sort.countingSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수_정렬하기_3_10989 {
  // 주요 관점은 정렬보다는 입출력 최적화에 가까운 듯함.

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[10001];

    for (int i = 0; i < n; i++) {
      short num = Short.parseShort(br.readLine());

      arr[num]++;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 1; i <= 10000; i++) {
        for (int j = 0; j < arr[i]; j++) {
          bw.write(i + "\n");
        }
      }

    bw.flush();
  }
}