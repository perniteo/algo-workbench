package BaekAlgo.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석_도둑_1202 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int k = Integer.parseInt(st.nextToken());

    int[][] gems = new int[n][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      gems[i][0] = Integer.parseInt(st.nextToken());
      gems[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(gems, Comparator.comparingInt(a -> a[0]));

    int[] bag = new int[k];

    for (int i = 0; i < k; i++) {
      bag[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(bag);

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    long maxValue = 0;

    int j = 0;

    for (int i = 0; i < k; i++) {
      int weight = bag[i];

      while (j < n && gems[j][0] <= weight) {
        maxHeap.add(gems[j][1]);
        j++;
      }

      if (!maxHeap.isEmpty()) {
        maxValue += maxHeap.poll();
      }
    }

    System.out.println(maxValue);

  }
}