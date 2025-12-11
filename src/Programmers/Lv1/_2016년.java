package Programmers.Lv1;

public class _2016년 {
    public String solution(int a, int b) {

      int[] days = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

      String[] week = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};

      int day = b + 5 - 1;
      // 1월 1일 금요일 idx = 5
      // 1월 1일 기준이므로 - 1

      for (int i = 0; i < a - 1; i++) {
        day += days[i];
      }


      String answer = week[day%7];

      return answer;
    }
}
