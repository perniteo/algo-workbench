package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem5073 {
  // 삼각형이 될 수 있는 조건인지 검사하고 가능하다면 어떤 삼각형인지 출력
  // 삼각형의 각 3개를 주는 것보다 조건이 하나가 더 추가된 꼴이다

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      ArrayList<Integer> lenList = new ArrayList<>();

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      if (x + y + z == 0) {
        break;
      }

      lenList.add(x);
      lenList.add(y);
      lenList.add(z);

      Collections.sort(lenList);

      if (lenList.get(0) + lenList.get(1) <= lenList.get(2)) {
        System.out.println("Invalid");
      } else {
        Set<Integer> set = new HashSet<>(lenList);
        switch (set.size()) {
          case 1:
            System.out.println("Equilateral");
            break;
          case 2:
            System.out.println("Isosceles");
            break;
          case 3:
            System.out.println("Scalene");
            break;
        }
      }
    }
  }
}