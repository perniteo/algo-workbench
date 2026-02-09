package Programmers.Lv2;

class DFS_타겟_넘버 {
    
    int[] numbers;
    
    int target;
    
    int answer = 0;
    
    public void dfs(int sum, int idx) {
        
        if (idx == numbers.length) {
          if (sum == target) {
            answer++;
          }
            return;
        }
           
        int n = numbers[idx];

        dfs(sum + n, idx + 1);
        dfs(sum - n, idx + 1);
    }
    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
}