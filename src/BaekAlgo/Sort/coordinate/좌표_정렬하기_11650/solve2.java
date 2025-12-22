package BaekAlgo.Sort.coordinate.좌표_정렬하기_11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Point 객체를 부여해서 x, y 좌표 값만 받았음
// 문제 의도에는 정확하다고 생각됨
// 효율은 크게 차이나지 않았음


public class solve2 {

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
      if (a.x != b.x)
        return a.x - b.x;
      return a.y - b.y;
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (Point p : list) {
      bw.write(p.x + " " + p.y + "\n");
    }

    bw.flush();
  }
}