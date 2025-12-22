package BaekAlgo.Sort.stable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순_정렬_10814 {

  // sorting 비교값이 같을 때
  // 순서를 보장하는 stable sort
  // 직접 id를 추가해서 구현했음

  static class Member {
    int id;
    int age;
    String name;

    Member(int id, int age, String name) {
      this.id = id;
      this.age = age;
      this.name = name;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    List<Member> list = new ArrayList<>();

    StringTokenizer st;

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      int age = Integer.parseInt(st.nextToken());

      String name = st.nextToken();

      list.add(new Member(i, age, name));
    }

    list.sort((a, b) -> {
      if (a.age == b.age) {
        return a.id - b.id;
      }
      return a.age - b.age;
    });

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (Member m : list) {
      bw.write(m.age + " " + m.name + "\n");
    }

    bw.flush();

  }
}