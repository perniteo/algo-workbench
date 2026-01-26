package BaekAlgo.dataStructure.hashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 인사성_밝은_곰곰이_25192 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int count = 0;

    Set<String> log = new HashSet<>();

    for (int i = 0; i < n; i++) {
      String command = br.readLine();
      if (command.equals("ENTER")) {
        count += log.size();
        log = new HashSet<>();
      } else {
        log.add(command);
      }
    }

    System.out.println(count + log.size());
  }
}