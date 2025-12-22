package BaekAlgo.set.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭_차집합_1269 {
  
  // 집합(set)의 성질을 이용하여 대칭 차집합을 구함
  // set 끼리 연산 가능한 점을 이용할까 생각했으나
  // 집합이라는 점을 더 생각해서 합집합 - 공집합을 이용해서 구했음

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());

    int b = Integer.parseInt(st.nextToken());

    Set<Integer> aSet = new HashSet<>();

    Set<Integer> bSet = new HashSet<>();

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < a; i++) {
      aSet.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < b; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (aSet.contains(num)) {
        bSet.add(num);
      }

      aSet.add(num);
    }

    System.out.println(aSet.size() - bSet.size());
  }
}