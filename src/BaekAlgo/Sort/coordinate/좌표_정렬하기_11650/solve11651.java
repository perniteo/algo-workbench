package BaekAlgo.Sort.coordinate.좌표_정렬하기_11650;

import java.io.*;
import java.util.*;

public class solve11651 {
  
  // 정렬 기준만 변화

  static class Point {
    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    List<Point> list = new ArrayList<>();

    StringTokenizer st;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list.add(new Point(x, y));
    }

    list.sort((a, b) -> {
      if (a.y != b.y) {
        return a.y - b.y;
      }
      return a.x - b.x;
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (Point p : list) {
      bw.write(p.x + " " + p.y + "\n");
    }

    bw.flush();
  }
}