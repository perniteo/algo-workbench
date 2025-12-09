package BaekAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2869 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    int days = 1;

    V -= A;

    int day = A - B;

//    정수 나누기 연산 할 때 올림처리 하는 법
//    수학적으로 기본.. 잊어 버리지 말기

//    if (V > 0) {
//      days = (V + day - 1) / day;
//    }

    if (V % day > 0) {
      days += V / day + 1;
    } else {
      days += V / day;
    }

    System.out.println(days);

  }
}

