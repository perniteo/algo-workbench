package Programmers.Lv2;

class Impl_방문_길이 {

  // 간선 표현을 위해 4차원 배열을 썼지만
  // 각 노드(정점)에서 4방향만 보면 되니까 3차원으로 압축가능
  // 또한 좌표압축(마스킹)을 통해 set 을 이용해서도 count 가능함
  // 중요한건 양방향 체크할 것

    boolean[][][][] visited = new boolean[11][11][11][11];
    
    int answer = 0;
    
    boolean validation(int r, int c) {
      if (r < 0 || c < 0 || r > 10 || c > 10) {
        return false;
      }
        return true;
    }
    
    void check(int r, int c, int nr, int nc) {
        if (!visited[r][c][nr][nc]) {
            visited[r][c][nr][nc] = true;
            visited[nr][nc][r][c] = true;
            answer++;
        }
    }
    
    public int solution(String dirs) {
        
        int r = 5;
        int c = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            char next = dirs.charAt(i);
            
            int nr = r;
            int nc = c;
          if (next == 'U') {
            nr--;
          } else if (next == 'D') {
            nr++;
          } else if (next == 'L') {
            nc--;
          } else if (next == 'R') {
            nc++;
          }
            
            if (validation(nr, nc)) {
                check(r, c, nr, nc);
                r = nr;
                c = nc;
            }
        }
        
        return answer;
    }
}