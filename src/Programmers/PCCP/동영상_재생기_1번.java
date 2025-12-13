package Programmers.PCCP;

public class 동영상_재생기_1번 {
  // 건너뛰기에 대한 자세한 설명이 없어서 이해하기 힘들었음
  // 오프닝 = 건너뛰기 라고 생각하고 작성
  // 정확히는 이동한 지점(pos)이 오프닝 구간 = 건너뛰기
    static int toSec(String ms) {
      return Integer.parseInt(ms.substring(0, 2)) * 60 + Integer.parseInt(ms.substring(3, 5));
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

      int totalLen = toSec(video_len);
      int curr = toSec(pos);
      int opStart = toSec(op_start);
      int opEnd = toSec(op_end);

      if (commands.length > 0 && opStart <= curr && curr <= opEnd) {
        curr = opEnd;
      }

      for (String c : commands) {
        if (c.equals("next")) {
          curr += 10;
          if (curr > totalLen) {
            curr = totalLen;
          }
        }
        else {
          curr -= 10;
          if (curr < 0) {
            curr = 0;
          }
        }
        if (opStart <= curr && curr <= opEnd) {
          curr = opEnd;
        }
      }

      StringBuilder sb = new StringBuilder();

      int m = curr / 60;
      int s = curr % 60;

      if (m < 10) {
        sb.append(0).append(m).append(":");
      } else {
        sb.append(m).append(":");
      }

      if (s < 10) {
        sb.append(0).append(s);
      } else {
        sb.append(s);
      }

      return sb.toString();
    }
  }
