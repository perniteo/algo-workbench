package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice2292 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int maxRoom = 1;
    int endOfLayer = 1;

    while (maxRoom < N) {
      maxRoom += endOfLayer++ * 6;
    }

    System.out.println(endOfLayer);
  }
}

