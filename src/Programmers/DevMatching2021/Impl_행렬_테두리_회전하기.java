package Programmers.DevMatching2021;

class Impl_행렬_테두리_회전하기 {

    // 시계 방향으로 한칸씩 밀고 이동
    // 따로 받고 큐로 한칸씩 밀고 다시 적용할까? 싶었는데
    // 순서에 맞게 조회하면서 한칸씩만 밀어주면 돼서 temp 사용 후 구현
    
    int[][] graph;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        graph = new int[rows + 1][columns + 1];
        
        int n = 1;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                graph[i][j] = n++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            
            int pick = 0;
            int min = 10000;
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];
            
            pick = graph[r1][c1];
            int temp = 0;
            
            for (int y = c1 + 1; y <= c2; y++) {
                temp = graph[r1][y];
                min = Math.min(temp, min);
                graph[r1][y] = pick;
                pick = temp;
            }
            
            for (int x = r1 + 1; x <= r2; x++) {
                temp = graph[x][c2];
                min = Math.min(temp, min);
                graph[x][c2] = pick;
                pick = temp;
            }
            
            for (int y = c2 - 1; y >= c1; y--) {
                temp = graph[r2][y];
                min = Math.min(temp, min);
                graph[r2][y] = pick;
                pick = temp;
            }
            
            for (int x = r2 - 1; x >= r1; x--) {
                temp = graph[x][c1];
                min = Math.min(temp, min);
                graph[x][c1] = pick;
                pick = temp;
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}