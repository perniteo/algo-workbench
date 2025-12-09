package Programmers;

public class 등굣길 {

  public int solution(int m, int n, int[][] puddles) {

    int[][] map = new int[n][m];

    map[0][0] = 1;

    //puddles 좌표는 (x,y) 형태로 주어지는데, 코드에서 map[y-1][x-1]로 변환하는 부분이 중요.

    for (int[] puddle : puddles) {
      map[puddle[1] - 1][puddle[0] - 1] = -1;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == -1) {
          map[i][j] = 0;
          continue;
        }
        if (i > 0) {
          map[i][j] += map[i - 1][j];
        }
        if (j > 0) {
          map[i][j] += map[i][j - 1];
        }
        map[i][j] %= 1000000007;

      }
    }

    return map[n - 1][m - 1];
  }

}
