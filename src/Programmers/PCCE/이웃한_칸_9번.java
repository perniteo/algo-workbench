package Programmers.PCCE;

public class 이웃한_칸_9번 {

  // 간단한 2차원 배열 상하좌우 검사 문제
  public int solution(String[][] board, int h, int w) {
    int answer = 0;

    int n = board.length;

    int[] dh = new int[]{0, 1, 0, -1};
    int[] dw = new int[]{1, 0, -1, 0};
    // 동 북 서 남

    String target = board[h][w];


    for (int i = 0; i < 4; i++) {
      int h_check = h + dh[i];
      int w_check = w + dw[i];

      if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
        if (board[h_check][w_check].equals(target)) {
          answer++;
        }
      }

    }
    return answer;
  }
}
